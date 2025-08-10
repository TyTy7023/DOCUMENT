USE TEST_InvestmentManagement


-- Danh sách tên và họ phổ biến
DECLARE @FirstNames TABLE (Name VARCHAR(50));
INSERT INTO @FirstNames VALUES ('John'), ('Michael'), ('Sarah'), ('Jessica'), ('David'), ('Emily'), ('James'), ('Linda'), ('Robert'), ('Linda'), ('Sophia'), ('Jack'),('Zhung');

DECLARE @LastNames TABLE (Name VARCHAR(50));
INSERT INTO @LastNames VALUES ('Smith'), ('Johnson'), ('Brown'), ('Williams'), ('Jones'), ('Davis'), ('Miller'), ('Taylor'), ('Anderson'), ('Thomas'), ('Tran'), ('Lee');

-- Chèn dữ liệu vào Managers
DECLARE @i INT = 1;
WHILE @i <= 1000
BEGIN
    -- Lấy tên ngẫu nhiên từ danh sách
    DECLARE @FirstName VARCHAR(50);
    DECLARE @LastName VARCHAR(50);

    SELECT TOP 1 @FirstName = Name FROM @FirstNames ORDER BY NEWID();
    SELECT TOP 1 @LastName = Name FROM @LastNames ORDER BY NEWID();

    INSERT INTO Managers (ManagerID, Name, Email, Phone, ExperienceYears, Description)
    VALUES (
        CONCAT('MG',@i),
        CONCAT(CASE 
                    WHEN @i % 2 = 0 THEN 'Mr. ' 
                    ELSE 'Ms. ' 
                END
			, @FirstName, ' ', @LastName),
        CONCAT(@FirstName, @i, 
                CASE 
                    WHEN @i % 2 = 0 THEN '@example.com' 
                    ELSE '@company.com' 
                END
        ),
        CONCAT('09', CAST(ABS(CHECKSUM(NEWID())) % 1000000000 AS VARCHAR(9))),
        ABS(CHECKSUM(NEWID())) % 30 + 1,
        CASE 
            WHEN @i % 3 = 0 THEN 'Leadership expert in industry.'
            WHEN @i % 3 = 1 THEN 'Experienced manager with a focus on team building.'
            ELSE 'Skilled professional with years of strategic expertise.'
        END
    );
    SET @i = @i + 1;
END;

-- Chèn dữ liệu vào Clients
-- Danh sách tên và họ phổ biến
DECLARE @FirstNames TABLE (Name VARCHAR(50));
INSERT INTO @FirstNames VALUES ('John'), ('Michael'), ('Sarah'), ('Jessica'), ('David'), ('Emily'), ('James'), ('Linda'), ('Robert'), ('Linda'), ('Sophia'), ('Jack'),('Zhung');

DECLARE @LastNames TABLE (Name VARCHAR(50));
INSERT INTO @LastNames VALUES ('Smith'), ('Johnson'), ('Brown'), ('Williams'), ('Jones'), ('Davis'), ('Miller'), ('Taylor'), ('Anderson'), ('Thomas'), ('Tran'), ('Lee');

DECLARE @i INT = 1;
WHILE @i <= 1000
BEGIN

    DECLARE @FirstName VARCHAR(50);
    DECLARE @LastName VARCHAR(50);
    -- Lấy tên ngẫu nhiên từ danh sách
    SELECT TOP 1 @FirstName = Name FROM @FirstNames ORDER BY NEWID();
    SELECT TOP 1 @LastName = Name FROM @LastNames ORDER BY NEWID();

    INSERT INTO Clients (ClientID, Name, Email, Phone, Address, RiskProfile, AccountBalance, DateCreated)
	VALUES (
		CONCAT('CL', @i),
		CONCAT(
			CASE WHEN @i % 2 = 0 THEN 'Mr. ' ELSE 'Ms. ' END, 
			@FirstName, ' ', @LastName
		),
		CONCAT(@FirstName, @i, 
			CASE WHEN @i % 2 = 0 THEN '@example.com' ELSE '@company.com' END
		),
		CONCAT('09', FORMAT(ABS(CHECKSUM(NEWID())) % 1000000000, 'D9')),
		CONCAT('Street ', (@i % 100) + 1, ', City ', (@i % 10) + 1),
		CASE 
			WHEN @i % 3 = 0 THEN N'Thấp'
			WHEN @i % 3 = 1 THEN N'Trung bình'
			ELSE N'Cao'
		END,
		CAST(RAND() * 100000 + 5000 AS BIGINT),
		DATEADD(DAY, -ABS(CHECKSUM(NEWID())) % 365, GETDATE())
	);

    SET @i = @i + 1;
END;

--Chèn dữ liệu vào Funds Table
DECLARE @i INT = 1;
WHILE @i <= 1000
BEGIN
    INSERT INTO Funds (FundID, FundName, FundType, StartDate, TotalAssets, ManagerID, PerformanceFee, ManagementFee)
	VALUES (
		CONCAT('F', @i),
		CONCAT(
			CHAR(65 + ABS(CHECKSUM(NEWID())) % 26), -- Sinh chữ cái ngẫu nhiên từ A-Z
			CHAR(65 + ABS(CHECKSUM(NEWID())) % 26), -- Sinh chữ cái ngẫu nhiên từ A-Z
			CHAR(65 + ABS(CHECKSUM(NEWID())) % 26), -- Sinh chữ cái ngẫu nhiên từ A-Z
			ABS(CHECKSUM(NEWID())) % 100 + 1 -- Thêm số ngẫu nhiên
		),
		CASE 
			WHEN @i % 4 = 0 THEN N'Cổ phiếu'
			WHEN @i % 4 = 1 THEN N'Trái phiếu'
			ELSE N'Hỗn hợp'
		END,
		DATEADD(DAY, -ABS(CHECKSUM(NEWID())) % 2000, GETDATE()), -- Ngày bắt đầu ngẫu nhiên trong khoảng 5 năm trở lại
		ABS(CHECKSUM(NEWID())) % 50000000 + 1000000, -- Tổng tài sản từ 1 triệu đến 50 triệu
		CONCAT('MG', @i), 
		ABS(CHECKSUM(NEWID())) % 6 + 5, -- PerformanceFee từ 5% đến 10%
		ABS(CHECKSUM(NEWID())) % 3 + 1  -- ManagementFee từ 1% đến 3%
	);
    SET @i = @i + 1;
END;

-- Chèn dữ liệu vào bảng Portfolios
DECLARE @i INT = 1;

WHILE @i <= 1000
BEGIN
    INSERT INTO Portfolios (PortfolioID, ClientID, FundID, RiskLevel, StartDate, Value)
    VALUES (
        CONCAT('P', @i),  -- PortfolioID: Tạo mã danh mục đầu tư, ví dụ: P1, P2, ...
        CONCAT('CL', ABS(CHECKSUM(NEWID())) % 1000 + 1),  -- ClientID: Giả định có tối đa 1000 khách hàng
        CONCAT('F', @i),  -- FundID: Giả định có tối đa 1000 quỹ (F1 đến F1000)
        ABS(CHECKSUM(NEWID())) % 5 + 1,  -- RiskLevel: Ngẫu nhiên từ 1 đến 5 (từ rủi ro thấp đến cao)
        DATEADD(DAY, -ABS(CHECKSUM(NEWID())) % 1000, GETDATE()), -- StartDate: Ngày bắt đầu ngẫu nhiên trong khoảng 3 năm trở lại
        ABS(CHECKSUM(NEWID())) % 10000000 + 1000000  -- Value: Giá trị danh mục đầu tư từ 1 triệu đến 10 triệu
    );

    SET @i = @i + 1;
END;

-- Chèn dữ liệu cho bảng Asset
DECLARE @i INT = 1;

WHILE @i <= 1000
BEGIN
    INSERT INTO Assets (AssetID, AssetName, AssetType, MarketValue, RiskLevel, FundID)
    VALUES (
        CONCAT('A', @i),  -- AssetID: Tạo mã tài sản, ví dụ: A1, A2, A3, ...
        CONCAT(CASE 
					WHEN @i % 3 = 0 THEN N'Cổ phiếu '
					WHEN @i % 3 = 1 THEN N'Trái phiếu '
					ELSE N'Bất động sản '
				END, 
				CHAR(65 + ABS(CHECKSUM(NEWID())) % 26),
				CHAR(65 + ABS(CHECKSUM(NEWID())) % 26),
				CHAR(65 + ABS(CHECKSUM(NEWID())) % 26),
				ABS(CHECKSUM(NEWID())) % 100 + 1), 
        CASE 
            WHEN @i % 3 = 0 THEN N'Cổ phiếu'
            WHEN @i % 3 = 1 THEN N'Trái phiếu'
            ELSE N'Bất động sản'
        END,  -- AssetType: Ngẫu nhiên chọn giữa Cổ phiếu, Trái phiếu, Bất động sản
        ABS(CHECKSUM(NEWID())) % 1000000000 + 1000000,  -- MarketValue: Giá trị tài sản từ 1 triệu đến 1 tỷ
        ABS(CHECKSUM(NEWID())) % 5 + 1,  -- RiskLevel: Ngẫu nhiên từ 1 đến 5 (từ rủi ro thấp đến cao)
        CONCAT('F', @i)  -- FundID: Quỹ ngẫu nhiên từ F1 đến F1000
    );
    SET @i = @i + 1;
END;

-- Chèn dữ liệu cho bảng RiskAssessment
DECLARE @i INT = 1;

WHILE @i <= 1000
BEGIN
	DECLARE @score INT = ABS(CHECKSUM(NEWID())) % 10 + 1;
    INSERT INTO RiskAssessment (AssessmentID, PortfolioID, AssetID, RiskScore, Comments)
    VALUES (
        CONCAT('RA', @i),  -- AssessmentID: Tạo mã đánh giá rủi ro
        CONCAT('P', @i),  -- PortfolioID đã được kiểm tra không trùng
        CONCAT('A', @i),  -- AssetID đã được kiểm tra không trùng
        @score,  -- RiskScore ngẫu nhiên từ 1 đến 10
        CASE 
            WHEN @score > 7 THEN N'High risk, careful monitoring required.'
            WHEN @score > 3 THEN N'Moderate risk, manageable with proper strategies.'
            ELSE N'Low risk, stable performance expected.'
        END  
    ); 

    SET @i = @i + 1;
END;

--Chèn dữ liệu vào bảng Performance
DECLARE @i INT = 1;
DECLARE @FundID NVARCHAR(50);
DECLARE @PerformanceID NVARCHAR(50);

WHILE @i <= 1000
BEGIN
    -- Tạo FundID ngẫu nhiên từ các ID trong bảng Funds
    SET @FundID = (SELECT TOP 1 FundID FROM Funds ORDER BY NEWID());
    
    -- Tạo PerformanceID theo số thứ tự
    SET @PerformanceID = CONCAT('P', @i);  

    -- Kiểm tra xem FundID có tồn tại trong bảng Funds không
    IF EXISTS (SELECT 1 FROM Funds WHERE FundID = @FundID)
    BEGIN
        -- Chèn dữ liệu vào bảng Performance nếu FundID hợp lệ
        INSERT INTO Performance (PerformanceID, FundID, Date, NetAssetValue, ReturnRate)
        VALUES (
            @PerformanceID,  -- PerformanceID
            @FundID,         -- FundID
            DATEADD(DAY, ABS(CHECKSUM(NEWID())) % 365, '2023-01-01'),  -- Ngày ngẫu nhiên trong vòng 1 năm từ 2023
            ABS(CHECKSUM(NEWID())) % 1000000000,  -- NetAssetValue ngẫu nhiên
            ROUND((ABS(CHECKSUM(NEWID())) % 2000 - 1000) / 100.0, 2)  -- ReturnRate ngẫu nhiên từ -10.00 đến +10.00
        );
    END
    ELSE
    BEGIN
        -- Nếu FundID không hợp lệ (không tồn tại), hiển thị thông báo (hoặc làm gì đó tùy nhu cầu)
        PRINT 'FundID ' + @FundID + ' does not exist in Funds table.';
    END

    -- Tăng biến @i để lặp lại cho đến khi hết 1000 bản ghi
    SET @i = @i + 1;
END;

-- Chèn dữ liệu vào bảng Dividends
DECLARE @i INT = 1;
DECLARE @FundID NVARCHAR(50);
DECLARE @PortfolioID NVARCHAR(50);
DECLARE @DividendID NVARCHAR(50);
DECLARE @Amount BIGINT;
DECLARE @DividendDate DATE;

WHILE @i <= 1000
BEGIN
    -- Lấy ngẫu nhiên FundID từ bảng Funds
    SET @FundID = (SELECT TOP 1 FundID FROM Funds ORDER BY NEWID());

    -- Lấy ngẫu nhiên PortfolioID từ bảng Portfolios
    SET @PortfolioID = (SELECT TOP 1 PortfolioID FROM Portfolios ORDER BY NEWID());

    -- Tạo DividendID theo số thứ tự
    SET @DividendID = CONCAT('D', @i);  

    -- Tạo ngày phân chia ngẫu nhiên trong vòng 1 năm từ 2023
    SET @DividendDate = DATEADD(DAY, ABS(CHECKSUM(NEWID())) % 365, '2023-01-01');

    -- Tạo số tiền phân chia ngẫu nhiên (ví dụ trong khoảng 500000 đến 5000000)
    SET @Amount = ABS(CHECKSUM(NEWID())) % 4500000 + 500000;

    -- Kiểm tra sự tồn tại của FundID và PortfolioID trước khi chèn
    IF EXISTS (SELECT 1 FROM Funds WHERE FundID = @FundID) AND EXISTS (SELECT 1 FROM Portfolios WHERE PortfolioID = @PortfolioID)
    BEGIN
        -- Chèn dữ liệu vào bảng Dividends nếu FundID và PortfolioID hợp lệ
        INSERT INTO Dividends (DividendID, FundID, PortfolioID, DividendDate, Amount)
        VALUES (
            @DividendID,      -- DividendID
            @FundID,          -- FundID
            @PortfolioID,     -- PortfolioID
            @DividendDate,    -- DividendDate
            @Amount           -- Amount
        );
    END
    ELSE
    BEGIN
        -- Nếu FundID hoặc PortfolioID không hợp lệ, hiển thị thông báo
        PRINT 'FundID ' + @FundID + ' or PortfolioID ' + @PortfolioID + ' does not exist.';
    END

    -- Tăng biến @i để tiếp tục vòng lặp
    SET @i = @i + 1;
END;

-- chèn dữ liệu vào bảng Transactions
DECLARE @i INT = 1;
DECLARE @TransactionID NVARCHAR(50);
DECLARE @PortfolioID NVARCHAR(50);
DECLARE @TransactionDate DATE;
DECLARE @TransactionType NVARCHAR(50);
DECLARE @Amount BIGINT;
DECLARE @Description NVARCHAR(255);

WHILE @i <= 1000
BEGIN
    -- Lấy ngẫu nhiên PortfolioID từ bảng Portfolios
    SET @PortfolioID = (SELECT TOP 1 PortfolioID FROM Portfolios ORDER BY NEWID());

    -- Tạo TransactionID theo số thứ tự
    SET @TransactionID = CONCAT('T', @i);  

    -- Tạo ngày giao dịch ngẫu nhiên trong vòng 1 năm từ 2023
    SET @TransactionDate = DATEADD(DAY, ABS(CHECKSUM(NEWID())) % 365, '2023-01-01');

    -- Lấy ngẫu nhiên loại giao dịch
    SET @TransactionType = 
        CASE ABS(CHECKSUM(NEWID())) % 4 
            WHEN 0 THEN N'Mua'
            WHEN 1 THEN N'Bán'
            WHEN 2 THEN N'Nạp tiền'
            ELSE N'Rút tiền'
        END;

    -- Tạo số tiền giao dịch ngẫu nhiên (từ 1,000,000 đến 50,000,000)
    SET @Amount = ABS(CHECKSUM(NEWID())) % 49000000 + 1000000;

    -- Sinh mô tả giao dịch động
    SET @Description = 
        CASE @TransactionType
            WHEN N'Mua' THEN N'Mua thêm chứng chỉ quỹ'
            WHEN N'Bán' THEN N'Bán chứng chỉ quỹ'
            WHEN N'Nạp tiền' THEN N'Nạp tiền vào tài khoản'
            ELSE N'Rút tiền từ tài khoản'
        END;

    -- Kiểm tra PortfolioID có tồn tại không trước khi chèn
    IF EXISTS (SELECT 1 FROM Portfolios WHERE PortfolioID = @PortfolioID)
    BEGIN
        INSERT INTO Transactions (TransactionID, PortfolioID, TransactionDate, TransactionType, Amount, Description)
        VALUES (@TransactionID, @PortfolioID, @TransactionDate, @TransactionType, @Amount, @Description);
    END
    ELSE
    BEGIN
        PRINT 'PortfolioID ' + @PortfolioID + ' does not exist.';
    END

    -- Tăng biến @i để tiếp tục vòng lặp
    SET @i = @i + 1;
END;

-- Chèn dữ liệu vào bảng AuditLogs (Nhật ký kiểm toán)
DECLARE @i INT = 1;
DECLARE @LogID NVARCHAR(50);
DECLARE @Timestamp DATETIME;
DECLARE @UserID INT;
DECLARE @ActionType NVARCHAR(50);
DECLARE @Details NVARCHAR(255);

WHILE @i <= 1000
BEGIN
    -- Sinh LogID
    SET @LogID = CONCAT('L', @i);

    -- Sinh thời gian ngẫu nhiên trong 1 năm qua
    SET @Timestamp = DATEADD(SECOND, ABS(CHECKSUM(NEWID())) % (365 * 24 * 60 * 60), '2023-01-01');

    -- Sinh UserID ngẫu nhiên từ 1 đến 50 (giả định có 50 người dùng)
    SET @UserID = ABS(CHECKSUM(NEWID())) % 50 + 1;

    -- Chọn hành động ngẫu nhiên
    SET @ActionType = 
        CASE ABS(CHECKSUM(NEWID())) % 3 
            WHEN 0 THEN 'Create'
            WHEN 1 THEN 'Update'
            ELSE 'Delete'
        END;

    -- Sinh mô tả chi tiết dựa trên hành động
    SET @Details = 
        CASE @ActionType
            WHEN 'Create' THEN 'Created a new record in the system.'
            WHEN 'Update' THEN 'Updated an existing record.'
            ELSE 'Deleted a record from the system.'
        END;

    -- Chèn dữ liệu vào bảng AuditLogs
    INSERT INTO AuditLogs (LogID, Timestamp, UserID, ActionType, Details)
    VALUES (@LogID, @Timestamp, @UserID, @ActionType, @Details);

    -- Tăng biến đếm
    SET @i = @i + 1;
END;
