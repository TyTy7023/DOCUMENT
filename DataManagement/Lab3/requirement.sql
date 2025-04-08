USE Northwind

-- query 20% products have unitprice largest 
WITH RankTable AS (
	SELECT P.Id, P.UnitPrice,
		ROW_NUMBER() OVER (ORDER BY P.UnitPrice DESC) AS RowNum
	FROM Product P
)
SELECT Id, UnitPrice, RowNum
FROM RankTable 
WHERE RowNum <= (
	SELECT COUNT(*) * 0.2 
	FROM Product
	)

--- For each invoice, export a list of products, quantity and 
-- percentage of that product in the invoice.
WITH countQuantity as (
	SELECT O.Id, OI.ProductId, OI.Quantity,
		(SUM(OI.Quantity) OVER (PARTITION BY OI.OrderId)) AS totalQuantity
	FROM [Order] O
	JOIN OrderItem OI ON O.Id = OI.OrderId
)
SELECT Id, ProductId, Quantity, totalQuantity,
	STR(Quantity*100/totalQuantity) + '%' AS PercentQty
FROM countQuantity

--- Export the list of suppliers with the columns USA, UK, France, Germany, Others. 
-- If any supplier belongs to these countries, we give the number 1 and the other is 0
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



