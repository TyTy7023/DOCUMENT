--Mức 1
USE InvestmentManagement;
SELECT *
FROM dbo.Clients
WHERE Address LIKE N'%Hà Nội%';

--Mức 2 
CREATE VIEW vw_Clients_HN AS
SELECT * FROM [SV1].[Clients_HN].[dbo].[Clients];
GO

CREATE VIEW vw_Clients_DN AS
SELECT * FROM [SV2].[Clients_DN].[dbo].[Clients];
GO

CREATE VIEW vw_Clients_HCM AS
SELECT * FROM [SV3].[Clients_HCM].[dbo].[Clients];
GO

CREATE VIEW vw_AllClients AS
SELECT * FROM vw_Clients_HN
UNION ALL
SELECT * FROM vw_Clients_HCM
UNION ALL
SELECT * FROM vw_Clients_DN;

SELECT * FROM vw_AllClients WHERE ClientID = 'CL001';

--Mức 3
IF EXISTS (
    SELECT 1
    FROM [SV1].[Clients_HN].[dbo].[Clients]
    WHERE Address LIKE N'%Hà Nội%'
)
BEGIN
    SELECT *
    FROM [SV1].[Clients_HN].[dbo].[Clients]
    WHERE Address LIKE N'%Hà Nội%';
END
ELSE IF EXISTS (
    SELECT 1
    FROM [SV2].[Clients_DN].[dbo].[Clients]
    WHERE Address LIKE N'%Hà Nội%'
)
BEGIN
    SELECT *
    FROM [SV2].[Clients_DN].[dbo].[Clients]
    WHERE Address LIKE N'%Hà Nội%';
END
ELSE IF EXISTS (
    SELECT 1
    FROM [SV3].[Clients_HCM].[dbo].[Clients]
    WHERE Address LIKE N'%Hà Nội%'
)
BEGIN
    SELECT *
    FROM [SV3].[Clients_HCm].[dbo].[Clients]
    WHERE Address LIKE N'%Hà Nội%';
END
ELSE
BEGIN
    SELECT N'Không có dữ liệu phù hợp' AS ThongBao;
END

--Gom mảnh dọc bằng JOIN theo khóa chính (Fund_ID)
SELECT * FROM [SV1].[Funds_Basic].[dbo].[Funds];
SELECT * FROM [SV2].[Funds_Fee].[dbo].[Funds];
SELECT 
    f1.FundID,
    f1.FundName,
    f1.FundType,
	f1.StartDate,
	f1.TotalAssets,
	f1.ManagerID,
    f2.PerformanceFee,
    f2.ManagementFee
FROM 
    [SV1].[Funds_Basic].[dbo].[Funds] AS f1
JOIN 
    [SV2].[Funds_Fee].[dbo].[Funds] AS f2
ON 
    f1.FundID = f2.FundID;

INSERT INTO Clients (ClientID, Name, Email, Phone, Address, RiskProfile, AccountBalance, DateCreated)
VALUES
(N'CL011', N'Bùi Anh Tuấn', N'Tuan@example.com', N'0908532411', N'Hà Nội', N'Cao', 59560000, '2011-07-12')

UPDATE Clients
SET Address = N'Đà Nẵng',
    Phone = '0909888999'
WHERE ClientID = 'CL011';

USE InvestmentManagement;
DELETE FROM [dbo].[Clients] 
WHERE ClientID = N'CL001'
