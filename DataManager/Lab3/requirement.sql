USE Northwind

-- query 20% products have unitprice largest 
SET STATISTICS TIME ON;

WITH RankTable AS (
	SELECT P.Id, P.UnitPrice,
		ROW_NUMBER() OVER (ORDER BY P.UnitPrice DESC) AS RowNumDesc,
		ROW_NUMBER() OVER (ORDER BY P.UnitPrice ASC) AS RowNumAsc
	FROM Product P
)
SELECT Id, UnitPrice
FROM RankTable 
WHERE RowNumDesc <= (
	SELECT CEILING(COUNT(*) * 0.2)
	FROM Product
)
ORDER BY UnitPrice ASC;

SET STATISTICS TIME OFF;


--- For each invoice, export a list of products, quantity and 
-- percentage of that product in the invoice.
SET STATISTICS TIME ON;
WITH countQuantity as (
	SELECT O.Id, OI.ProductId, OI.Quantity,
		(SUM(OI.Quantity) OVER (PARTITION BY OI.OrderId)) AS totalQuantity
	FROM [Order] O
	JOIN OrderItem OI ON O.Id = OI.OrderId
)
SELECT Id, ProductId, Quantity, totalQuantity,
	STR(Quantity*100/totalQuantity) + '%' AS PercentQty
FROM countQuantity
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
WITH OrderTotal AS (
    SELECT 
        OI.OrderId,
        SUM(OI.Quantity) AS TotalQuantity
    FROM OrderItem OI
    GROUP BY OI.OrderId
),
OrderWithPercent AS (
    SELECT 
        O.Id, OI.ProductId, OI.Quantity, OT.TotalQuantity,
        CAST(OI.Quantity * 100.0 / NULLIF(OT.TotalQuantity, 0) AS DECIMAL(5,2)) AS PercentQty
    FROM [Order] O
    JOIN OrderItem OI ON O.Id = OI.OrderId
    JOIN OrderTotal OT ON OI.OrderId = OT.OrderId
)
SELECT Id, ProductId, Quantity, totalQuantity,
    CAST(PercentQty AS VARCHAR) + '%' AS PercentQtyStr
FROM OrderWithPercent;
SET STATISTICS TIME OFF;

--- Export the list of suppliers with the columns USA, UK, France, Germany, Others. 
-- If any supplier belongs to these countries, we give the number 1 and the other is 0
SET STATISTICS TIME ON;
WITH SupplierCategory AS (
    SELECT 
        S.Id, S.CompanyName,
        CASE 
            WHEN S.Country = 'USA' THEN 'USA'
            WHEN S.Country = 'UK' THEN 'UK'
            WHEN S.Country = 'France' THEN 'France'
            WHEN S.Country = 'Germany' THEN 'Germany'
            ELSE 'Others'
        END AS Category,
        1 AS Value
    FROM Supplier S
)
SELECT Id, CompanyName, 
	COALESCE([USA], 0) AS USA, 
    COALESCE([UK], 0) AS UK, 
    COALESCE([France], 0) AS France, 
    COALESCE([Germany], 0) AS Germany, 
    COALESCE([Others], 0) AS Others
FROM (
    SELECT Id, CompanyName, Category, Value 
    FROM SupplierCategory
) src
PIVOT (
    SUM(Value) FOR Category IN ([USA], [UK], [France], [Germany], [Others])
) pvt
ORDER BY Id;
SET STATISTICS TIME OFF;



)

SET STATISTICS TIME ON;
WITH CustomerOrders AS (
SELECT c.Id, c.FirstName, c.LastName, COUNT(o.Id) AS TotalOrders
FROM Customer c
LEFT JOIN "Order" o ON c.Id = o.CustomerId
GROUP BY c.Id, c.FirstName, c.LastName
)
SELECT Id, FirstName, LastName, TotalOrders,
DENSE_RANK() OVER (ORDER BY TotalOrders DESC) AS Rank,
NTILE(3) OVER (ORDER BY TotalOrders DESC) AS GroupCategory
FROM CustomerOrders;
SET STATISTICS TIME OFF;