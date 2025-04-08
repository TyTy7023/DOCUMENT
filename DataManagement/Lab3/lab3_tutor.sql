USE Northwind

-- Sap xep OrderItem tang dan theo Quantity va tim 10%
-- dong co quantity cao nhat
SELECT * 
FROM
(
	SELECT RowNum, Id, ProductId, OrderId, Quantity, 
	Max(RowNum)	OVER (ORDER BY (SELECT 1)) AS RowLast -- lay max cua rownum dien vao rowlast 
	FROM(
		SELECT ROW_NUMBER() OVER (ORDER BY Quantity) AS RowNum, -- danh so thu tu theo quantity
			Id,OrderId, ProductId, Quantity
		FROM OrderItem
	) AS DerivedTable -- Tao bang tam de tinh toan
) Report -- dat ten cho bang
WHERE Report.RowNum >= 0.1 * RowLast

-- Xuat danh sach cac hoa don (OrderNumber, OrderDate, CustomerId, TotalAmount)
-- kem theo thong tin hoa don do co tong so luong mua chiem bao nhieu % cua mot khach hang.
SELECT OrderNumber, OrderDate, CustomerId, TotalAmount,
FROM
