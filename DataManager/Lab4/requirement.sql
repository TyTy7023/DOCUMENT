SET STATISTICS TIME ON;
WITH OrderTotals AS (
SELECT OrderId, ProductId, Quantity,
	SUM(Quantity) OVER (PARTITION BY OrderId) AS TotalQuantity
FROM dbo.OrderItem
)
SELECT OrderId, ProductId, Quantity,
	CAST (Quantity * 100.0 / TotalQuantity AS DECIMAL(6,2)) AS Percentage
FROM OrderTotals
ORDER BY OrderId, ProductId;
SET STATISTICS TIME OFF;

--cau 3
SET STATISTICS TIME ON;
SELECT
oi.OrderId,
oi.ProductId,
p.ProductName,
oi.UnitPrice,
oi.Quantity,
ISNULL (s.Fax, s.Phone) AS ContactInfo,
CASE
WHEN s.Fax IS NOT NULL THEN 'Fax'
ELSE 'Phone'
END AS ContactType
FROM OrderItem oi
JOIN Product p ON oi. ProductId = p.Id
JOIN Supplier s ON p.SupplierId = s.Id;
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SELECT
DB_ID() AS DatabaseId,
OBJECT_ID('dbo.Supplier' ) AS SupplierTableId,
USER_ID() AS UserId,
USER_NAME() AS UserName,
SUSER_NAME () AS LoginName;
SET STATISTICS TIME OFF;

SET STATISTICS TIME ON;
SELECT OBJECT_NAME (object_id) 
	AS TableName, user_seeks, 
	user_scans, user_lookups, user_updates
FROM sys.dm_db_index_usage_stats
WHERE object_id = OBJECT_ID('dbo.Order');
SET STATISTICS TIME OFF;
