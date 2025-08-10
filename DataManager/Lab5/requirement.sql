CREATE VIEW ouvw_DetailProductInOrder AS
SELECT 
    o.Id AS OrderId, 
    o.OrderNumber, 
    o.OrderDate, 
    oi.ProductId, 
    CONCAT(p.ProductName, ' ', p.Package) AS ProductInfo, 
    oi.UnitPrice, 
    oi.Quantity
FROM 
    [Order] o
JOIN 
    OrderItem oi ON o.Id = oi.OrderId
JOIN 
    Product p ON oi.ProductId = p.Id;

CREATE VIEW ouvw_AllProductInOrder AS
SELECT 
    o.Id AS OrderId, 
    o.OrderNumber, 
    o.OrderDate, 
    -- Sử dụng FOR XML PATH để tạo danh sách sản phẩm
    STUFF((
        SELECT ',' + CAST(oi.ProductId AS VARCHAR(10))
        FROM OrderItem oi
        WHERE oi.OrderId = o.Id
        FOR XML PATH('')
    ), 1, 1, '') AS ProductList,
    -- Tính tổng tiền theo OrderId
    SUM(oi.UnitPrice * oi.Quantity) AS TotalAmount
FROM 
    [Order] o
JOIN 
    OrderItem oi ON o.Id = oi.OrderId
GROUP BY 
    o.Id, o.OrderNumber, o.OrderDate;

SET STATISTICS TIME ON;

SELECT OrderId, OrderNumber,OrderDate, ProductId, 
	ProductInfo, UnitPrice, Quantity
FROM ouvw_DetailProductInOrder
WHERE MONTH(OrderDate) = 7;

SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SELECT *
FROM ouvw_AllProductInOrder
WHERE LEN(ProductList) - LEN(REPLACE(ProductList, ',', '')) + 1 >= 3;
SET STATISTICS TIME OFF;

INSERT INTO ouvw_DetailProductInOrder (OrderId, ProductId, Quantity)
VALUES (1, 2, 3);

CREATE VIEW view_name AS
SELECT ...
FROM ...
WHERE điều_kiện
WITH CHECK OPTION;


CREATE TRIGGER trg_ouvw_DetailProductInOrder_block_mods
ON ouvw_DetailProductInOrder
INSTEAD OF INSERT, UPDATE, DELETE
AS
BEGIN
    RAISERROR('This view is readonly.', 16, 1);
END;


CREATE TRIGGER trg_ouvw_AllProductInOrder_block_mods
ON ouvw_AllProductInOrder
INSTEAD OF INSERT, UPDATE, DELETE
AS
BEGIN
    RAISERROR('This view is readonly.', 16, 1);
END;

REVOKE INSERT, UPDATE, DELETE ON ouvw_DetailProductInOrder FROM PUBLIC;
REVOKE INSERT, UPDATE, DELETE ON ouvw_AllProductInOrder FROM PUBLIC;

SET STATISTICS TIME ON;

-- Gọi view 1
SELECT * FROM ouvw_DetailProductInOrder;

-- Gọi view 2
SELECT * FROM ouvw_AllProductInOrder;

SET STATISTICS TIME OFF;


