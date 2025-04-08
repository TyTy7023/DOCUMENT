USE Northwind

-- Query Customer
SELECT * FROM Customer

-- Query id, FullName, city, country
SELECT Id,CONCAT(FirstName, ' ', LastName) AS FullName, City, Country
FROM Customer

--Query NumOfCustomer from Germany and UK
SELECT Id, LastName, Country
FROM Customer
--WHERE Country like 'Germany' or Country like 'UK'
WHERE Country in ('Germany','UK')

SELECT COUNT(Id) AS NumOfCustomer
FROM Customer
WHERE Country like 'Germany' or Country like 'UK'
GROUP BY Country

--Query list of customers by ascending of FistName and descending of Country
SELECT *
FROM Customer
ORDER BY FirstName ASC, Country DESC 

--Query customers have id is 5,10 - 1 to 10 - 5 to 10
SELECT * FROM Customer WHERE Id IN (10,5)
SELECT * FROM Customer WHERE Id BETWEEN 1 AND 10
SELECT * FROM Customer WHERE Id BETWEEN 5 AND 10

-- Query customers for products (Product) that are packaged in bottles with prices
-- between 15 and 20 that are not from supplier with ID 16.
SELECT * 
FROM Product
WHERE SupplierId <> 16
	AND UnitPrice BETWEEN  15.00 AND 20
	AND Package LIKE '%bottle%'