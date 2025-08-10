USE Northwind;

-- Voi moi khach hang cho biet Ma Khach Hang, Ten Khach Hang, Tong Gia Tri Trung Binh va Tong So Hoa Don
-- va sap xep theo Tong So Hoa Don
SELECT C.Id, C.FirstName + ' ' + C.LastName AS [Ho Ten],
COUNT(O.OrderNumber) AS [Tong So Hoa Don],
AVG(O.TotalAmount) [Tong Gia Trung Binh]
FROM Customer AS C
INNER JOIN [Order] AS O ON C.Id = O.CustomerId
GROUP BY C.Id, C.FirstName, C.LastName
ORDER BY [Tong So Hoa Don] DESC

-- Nhu cau tren nhung chi xuat danh sach khach hang khong co hoac co it hon 3 hoa don mua hang
SELECT C.FirstName + ' ' + C.LastName AS [Ho Ten],
ISNULL(COUNT(O.OrderNumber),0) AS [Tong So Hoa Don],
ISNULL(AVG(O.TotalAmount),0) [Tong Gia Trung Binh]
FROM Customer AS C
LEFT JOIN [Order] AS O ON C.Id = O.CustomerId
GROUP BY C.FirstName, C.LastName
HAVING COUNT(O.OrderNumber) < 3
ORDER BY [Tong So Hoa Don] DESC

-- Xuat danh sach cac OrderNumber kem theo Total Amount va Description
-- Description la "Under Average" neu so luong Total Amount nho hon so luong trung binh
-- va "Above Average" neu nguoc lai
SELECT OrderNumber, TotalAmount, 'Above Average' AS [Description]
FROM [Order]
WHERE TotalAmount >= (SELECT AVG(TotalAmount) FROM [Order])
UNION
SELECT OrderNumber, TotalAmount, 'Below Average' AS [Description]
FROM [Order]
WHERE TotalAmount < (SELECT AVG(TotalAmount) FROM [Order])

-- Xuat thong tin nhung quoc gia nao vua co nha cung cap va vua co khach hang
SELECT Country
FROM Customer
INTERSECT
SELECT Country
FROM Supplier

-- Xuat thong tin nhung quoc gia nao chi co khach hang ma khong co nha cung cap
SELECT Country
FROM Customer
EXCEPT
SELECT Country
FROM Supplier

-- Xuat thong tin nhung san pham nao co gia cao hon gia cac san pham cua SupplierId 8
SELECT *
FROM Product
WHERE UnitPrice >= ALL (SELECT UnitPrice FROM Product WHERE SupplierId = 8)

-- Xuat danh sach cac san pham co nha cung cap nhieu thu 4 trong cac nha cung cap
SELECT *
FROM Product
WHERE SupplierId IN (SELECT TOP 4 SupplierId FROM Product GROUP BY SupplierId ORDER BY COUNT(ProductName) DESC)

-- Xuat danh sach cac khach hang co hoa don vao thang 7
SELECT *
FROM Customer C
WHERE EXISTS (SELECT * FROM [Order] AS O WHERE O.CustomerId = C.Id AND MONTH(O.OrderDate) = 7)

-- LAB 2 - REQUIREMENT
USE Northwind;

-- 1. Xuat danh sach nha cung cap kem theo gia min va max cua san pham ma ho cung cap
SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone, 
       MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
JOIN Product P ON S.Id = P.SupplierId
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone
ORDER BY S.Id;

-- 2. Chi xuat danh sach nha cung cap co su khac biet gia (max - min) khong qua lon (<= 30)
SELECT S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone, 
       MIN(P.UnitPrice) AS MinPrice, MAX(P.UnitPrice) AS MaxPrice
FROM Supplier S
JOIN Product P ON S.Id = P.SupplierId
GROUP BY S.Id, S.CompanyName, S.ContactName, S.City, S.Country, S.Phone
HAVING MAX(P.UnitPrice) - MIN(P.UnitPrice) <= 30
ORDER BY S.Id;

-- 3. Xuat danh sach hoa don kem tong gia chi tra va mo ta VIP / Normal
SELECT O.Id, O.OrderNumber, O.OrderDate, 
       SUM(OI.UnitPrice * OI.Quantity) AS TotalCost,
       'VIP' AS Description
FROM [Order] O
JOIN OrderItem OI ON O.Id = OI.OrderId
GROUP BY O.Id, O.OrderNumber, O.OrderDate
HAVING SUM(OI.UnitPrice * OI.Quantity) > 1500

UNION

SELECT O.Id, O.OrderNumber, O.OrderDate, 
       SUM(OI.UnitPrice * OI.Quantity) AS TotalCost,
       'Normal' AS Description
FROM [Order] O
JOIN OrderItem OI ON O.Id = OI.OrderId
GROUP BY O.Id, O.OrderNumber, O.OrderDate
HAVING SUM(OI.UnitPrice * OI.Quantity) <= 1500;

-- 4. Xuat danh sach hoa don trong thang 7 nhung ngoai tru khach hang tu France
SELECT Id, OrderNumber, OrderDate
FROM [Order]
WHERE MONTH(OrderDate) = 7
EXCEPT
SELECT O.Id, O.OrderNumber, O.OrderDate
FROM [Order] O
JOIN Customer C ON O.CustomerId = C.Id
WHERE MONTH(O.OrderDate) = 7 AND C.Country = 'France';

-- 5. Xuat danh sach hoa don co TotalAmount nam trong top 5
SELECT Id, OrderNumber, OrderDate, TotalAmount
FROM [Order]
WHERE TotalAmount IN (
    SELECT DISTINCT TOP 5 TotalAmount
    FROM [Order]
    ORDER BY TotalAmount DESC
);
