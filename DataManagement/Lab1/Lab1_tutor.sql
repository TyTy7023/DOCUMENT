USE Northwind

--query database in sys--
SELECT name FROM master.dbo.sysdatabases

--Print a message to see if the Northwind database exists or not--
IF db_id('Northwind') IS NOT NULL 
	BEGIN SELECT 'DATABASE IS EXSIT' END
ELSE 
	BEGIN SELECT'DATABASE IS NOT EXSIT' END

--Query Supplier table--
SELECT TOP 5* FROM Supplier

--Query detail data and split data in column--
SELECT TOP 5 Id,
	LEFT(ContactName, CHARINDEX(' ',ContactName)-1) AS 'First Name',
	SUBSTRING(ContactName,CHARINDEX(' ', ContactName) + 1,100) AS 'Last Name',
	City
FROM Supplier

--Query detail data with sort--
SELECT TOP 5 Id,
	LEFT(ContactName, CHARINDEX(' ',ContactName)-1) AS 'First Name',
	SUBSTRING(ContactName,CHARINDEX(' ', ContactName) + 1,100) AS 'Last Name',
	City
FROM Supplier
ORDER BY 'First Name' DESC, City DESC

-- LAB 1 - REQUIREMENT
USE Northwind;

-- Truy vấn danh sách tất cả khách hàng
SELECT * FROM Customer;

-- Truy vấn danh sách khách hàng với các thông tin Id, FullName, City, Country
SELECT Id AS CustomerId, 
       FirstName + ' ' + LastName AS FullName, 
       City, 
       Country
FROM Customer;

-- Đếm số khách hàng từ Germany và UK, liệt kê danh sách khách hàng
SELECT COUNT(*) AS TotalCustomers
FROM Customer
WHERE Country IN ('Germany', 'UK');

SELECT Id AS CustomerId, FirstName + ' ' + LastName AS FullName, Country
FROM Customer
WHERE Country IN ('Germany', 'UK');

-- Liệt kê danh sách khách hàng theo thứ tự tăng dần của FirstName và giảm dần của Country
SELECT Id AS CustomerId, FirstName + ' ' + LastName AS FullName, Country
FROM Customer
ORDER BY FirstName ASC, Country DESC;

-- Truy vấn danh sách khách hàng với ID là 5,10, từ 1-10, và từ 5-10
SELECT * FROM Customer WHERE Id IN (5, 10);
SELECT * FROM Customer WHERE Id BETWEEN 1 AND 10;
SELECT * FROM Customer WHERE Id BETWEEN 5 AND 10;

-- Truy vấn các khách hàng mua sản phẩm đóng gói dạng bottles có giá từ 15 đến 20, không từ nhà cung cấp ID 16
SELECT DISTINCT C.Id AS CustomerId, C.FirstName + ' ' + C.LastName AS FullName
FROM Customer C
JOIN [Order] O ON C.Id = O.CustomerId
JOIN OrderItem OI ON O.Id = OI.OrderId
JOIN Product P ON OI.ProductId = P.Id
JOIN Supplier S ON P.SupplierId = S.Id
WHERE P.Package LIKE '%bottle%'
AND P.UnitPrice BETWEEN 15 AND 20
AND S.Id <> 16;
