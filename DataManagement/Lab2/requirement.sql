USE Northwind

--Query Supplier and min max price of products
SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone,
MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
JOIN Product P ON S.Id = P.SupplierId
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone --****
ORDER BY S.Id ASC

-- Same sentence above, but only export a list of suppliers 
-- with a price difference (max – min) that is not too big (<30)
SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone,
MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
JOIN Product P ON S.Id = P.SupplierId
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone --****
HAVING (MAX(P.UnitPrice) - MIN(P.UnitPrice)) < 30
ORDER BY S.Id 

-- Query oders and set description
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
HAVING SUM(OI.UnitPrice * OI.Quantity) < 1500

-- Query order from 7 months ago execpt custom hace name France
--C1
SELECT O.Id, O.OrderNumber, O.OrderDate
FROM [Order] O
JOIN Customer C ON O.CustomerId = C.Id
WHERE C.Country NOT LIKE '%France%' AND MONTH(O.OrderDate) = 7
--C2
SELECT Id, OrderNumber, OrderDate
FROM [Order]
WHERE MONTH(OrderDate) = 7
EXCEPT
SELECT O.Id, O.OrderNumber, O.OrderDate
FROM [Order] O
JOIN Customer C ON O.CustomerId = C.Id
WHERE MONTH(O.OrderDate) = 7 AND C.Country = 'France';

--query top 5 order TotalAmount
SELECT Id, OrderNumber, OrderDate, TotalAmount
FROM [Order]
WHERE TotalAmount IN (
	SELECT DISTINCT TOP 5 TotalAmount
	FROM [Order]
	ORDER BY TotalAmount DESC
)