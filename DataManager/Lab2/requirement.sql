USE Northwind

--Query Supplier and min max price of products
SET STATISTICS TIME ON;
SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone,
	MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
JOIN Product P ON S.Id = P.SupplierId
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone 
ORDER BY S.Id ASC
SET STATISTICS TIME OFF;
--C2
SET STATISTICS TIME ON;
SELECT S.Id, S.CompanyName,  S.ContactName, 
    S.City, S.Country, S.Phone,
    ISNULL(MIN(P.UnitPrice), 0) AS MinPrice,
    ISNULL(MAX(P.UnitPrice), 0) AS MaxPrice
FROM Supplier S
LEFT JOIN Product P ON S.Id = P.SupplierId
GROUP BY 
    S.Id, S.CompanyName, S.ContactName, 
    S.City,  S.Country, S.Phone
ORDER BY S.Id ASC;
SET STATISTICS TIME OFF;

-- Same sentence above, but only export a list of suppliers 
-- with a price difference (max – min) that is not too big (<30)
SET STATISTICS TIME ON;
SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone,
MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
JOIN Product P ON S.Id = P.SupplierId
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone --****
HAVING (MAX(P.UnitPrice) - MIN(P.UnitPrice)) < 30
ORDER BY S.Id 
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;

SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone,
       MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
LEFT JOIN Product P ON S.Id = P.SupplierId  -- Sử dụng LEFT JOIN để bao gồm các nhà cung cấp không có sản phẩm
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone
HAVING (MAX(P.UnitPrice) - MIN(P.UnitPrice)) < 30
ORDER BY S.Id

SET STATISTICS TIME OFF;


-- Query oders and set description
SET STATISTICS TIME ON;
SELECT O.Id, O.OrderNumber, O.OrderDate, 
	SUM(OI.UnitPrice * OI.Quantity) AS Total, 'VIP' AS [Description]
FROM [Order] O
JOIN OrderItem OI ON O.Id = OI.OrderId
GROUP BY O.Id, O.OrderNumber, O.OrderDate
HAVING SUM(OI.UnitPrice * OI.Quantity) > 1500

UNION

SELECT O.Id, O.OrderNumber, O.OrderDate, 
	SUM(OI.UnitPrice * OI.Quantity) AS Total, 'NORMAL' AS [Description]
FROM [Order] O
JOIN OrderItem OI ON O.Id = OI.OrderId
GROUP BY O.Id, O.OrderNumber, O.OrderDate
HAVING SUM(OI.UnitPrice * OI.Quantity) <= 1500
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SELECT O.Id, O.OrderNumber, O.OrderDate,
       SUM(OI.UnitPrice * OI.Quantity) AS TotalCost,
       CASE 
           WHEN SUM(OI.UnitPrice * OI.Quantity) > 1500 THEN 'VIP'
           ELSE 'NORMAL'
       END AS Description
FROM [Order] O
JOIN OrderItem OI ON O.Id = OI.OrderId
GROUP BY O.Id, O.OrderNumber, O.OrderDate
HAVING SUM(OI.UnitPrice * OI.Quantity) > 0 
ORDER BY O.Id;
SET STATISTICS TIME OFF;


-- Query order from 7 months ago execpt custom hace name France
--C1
SELECT O.Id, O.OrderNumber, O.OrderDate
FROM [Order] O
JOIN Customer C ON O.CustomerId = C.Id
WHERE C.Country NOT LIKE '%France%' AND MONTH(O.OrderDate) = 7
--C2
SET STATISTICS TIME ON;
SELECT Id, OrderNumber, OrderDate
FROM [Order]
WHERE MONTH(OrderDate) = 7
EXCEPT
SELECT O.Id, O.OrderNumber, O.OrderDate
FROM [Order] O
JOIN Customer C ON O.CustomerId = C.Id
WHERE MONTH(O.OrderDate) = 7 AND C.Country = 'France';
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SET STATISTICS TIME ON;

SELECT o.Id, o.OrderNumber, o.OrderDate
FROM [Order] o
WHERE MONTH(o.OrderDate) = 7
AND NOT EXISTS (
    SELECT 1
    FROM Customer c
    WHERE c.Id = o.CustomerId AND c.Country = 'France'
);

SET STATISTICS TIME OFF;


--query top 5 order TotalAmount
SET STATISTICS TIME ON;
SELECT Id, OrderNumber, OrderDate, TotalAmount
FROM [Order]
WHERE TotalAmount IN (
	SELECT DISTINCT TOP 5 TotalAmount
	FROM [Order]
	ORDER BY TotalAmount DESC
)
SET STATISTICS TIME OFF;