USE Northwind

-- Query Customer
SET STATISTICS TIME ON;
SELECT Id, FirstName, LastName, City, Country, Phone
FROM Customer;
SET STATISTICS TIME OFF;

SELECT COLUMN_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'Product';

-- Query the list of Customers by information Id, 
-- FullName (a combination of FirstName-LastName), 
-- City, Country
SET STATISTICS TIME ON;
SELECT Id,CONCAT(FirstName, ' ', LastName) AS FullName,
		City, Country
FROM Customer
SET STATISTICS TIME OFF;

--Query NumOfCustomer from Germany and UK
SET STATISTICS TIME ON;
SELECT COUNT(Id) AS NumOfCustomer
FROM Customer
--WHERE Country like 'Germany' or Country like 'UK'
WHERE Country in ('Germany','UK')

SELECT Id, LastName, Country
FROM Customer
WHERE Country in ('Germany','UK')
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SELECT 
    COUNT(Id) OVER () AS NumOfCustomer, 
    Id, 
    LastName, 
    Country
FROM Customer
WHERE Country IN ('Germany', 'UK'); 
SET STATISTICS TIME OFF;

--Query list of customers by ascending of FistName and descending of Country
SET STATISTICS TIME ON;
SELECT Id, FirstName, LastName, City, Country, Phone
FROM Customer
ORDER BY FirstName ASC, Country DESC 
SET STATISTICS TIME OFF;

--Query customers have id is 5,10 - 1 to 10 - 5 to 10
SET STATISTICS TIME ON;
SELECT Id, FirstName, LastName, City, Country, Phone 
FROM Customer WHERE Id IN (10,5)

SELECT Id, FirstName, LastName, City, Country, Phone 
FROM Customer WHERE Id BETWEEN 1 AND 10

SELECT Id, FirstName, LastName, City, Country, Phone 
FROM Customer WHERE Id BETWEEN 5 AND 10
SET STATISTICS TIME OFF;

-- Query customers for products (Product) that are packaged in bottles with prices
-- between 15 and 20 that are not from supplier with ID 16.
SET STATISTICS TIME ON;
	SELECT DISTINCT c.Id, c.LastName, c.FirstName
	FROM Customer c
	JOIN dbo.[Order] o ON c.Id = o.CustomerID
	JOIN dbo.OrderItem oi ON o.Id = oi.OrderID
	JOIN dbo.Product p ON oi.ProductID = p.Id
	JOIN dbo.Supplier s ON p.SupplierID = s.Id
	WHERE p.Package LIKE '%bottle%'
	AND p.UnitPrice BETWEEN 15 AND 20
	AND s.Id NOT IN (16);
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SELECT DISTINCT c.Id, c.LastName, c.FirstName
FROM Customer c
WHERE EXISTS (
    SELECT 1
    FROM dbo.[Order] o
    JOIN dbo.OrderItem oi ON o.Id = oi.OrderID
    JOIN dbo.Product p ON oi.ProductID = p.Id
    JOIN dbo.Supplier s ON p.SupplierID = s.Id
    WHERE o.CustomerID = c.Id
      AND p.Package LIKE '%bottle%'
      AND p.UnitPrice BETWEEN 15 AND 20
      AND s.Id <> 16
);
SET STATISTICS TIME OFF;
