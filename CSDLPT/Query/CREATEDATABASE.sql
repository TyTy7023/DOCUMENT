
--CREATE DATABASE InvestmentManagement;
USE InvestmentManagement;

-- Bảng Clients (Khách hàng)
CREATE TABLE Clients (
    ClientID NVARCHAR(50) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(20) NOT NULL,  
    Address NVARCHAR(255) NOT NULL,
    RiskProfile NVARCHAR(20) NOT NULL CHECK (RiskProfile IN (N'Thấp', N'Trung bình', N'Cao')),
    AccountBalance BIGINT NOT NULL,
    DateCreated DATE NOT NULL
);

-- Bảng Managers (Quản lý quỹ)
CREATE TABLE Managers (
    ManagerID NVARCHAR(50) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(20) NOT NULL,
    ExperienceYears INT NOT NULL,
    Description NVARCHAR(255) NOT NULL
);

-- Bảng Funds (Quỹ đầu tư)
CREATE TABLE Funds (
    FundID NVARCHAR(50) PRIMARY KEY,
    FundName NVARCHAR(100) NOT NULL,
    FundType NVARCHAR(50) NOT NULL CHECK (FundType IN (N'Cổ phiếu', N'Trái phiếu', N'Hỗn hợp')),
    StartDate DATE NOT NULL,
    TotalAssets BIGINT NOT NULL,
    ManagerID NVARCHAR(50) NOT NULL,
    PerformanceFee INT NOT NULL,
    ManagementFee INT NOT NULL,
    FOREIGN KEY (ManagerID) REFERENCES Managers(ManagerID)
);

-- Bảng Portfolios (Danh mục đầu tư)
CREATE TABLE Portfolios (
    PortfolioID NVARCHAR(50) PRIMARY KEY,
    ClientID NVARCHAR(50) NOT NULL,
    FundID NVARCHAR(50) NOT NULL,
    RiskLevel INT NOT NULL,
    StartDate DATE NOT NULL,
    Value BIGINT NOT NULL,
    FOREIGN KEY (ClientID) REFERENCES Clients(ClientID),
    FOREIGN KEY (FundID) REFERENCES Funds(FundID)
);

-- Bảng Assets (Tài sản)
CREATE TABLE Assets (
    AssetID NVARCHAR(50) PRIMARY KEY,
    AssetName NVARCHAR(100) NOT NULL,
    AssetType NVARCHAR(50) NOT NULL CHECK (AssetType IN (N'Cổ phiếu', N'Trái phiếu', N'Bất động sản')),
    MarketValue BIGINT NOT NULL,
    RiskLevel INT NOT NULL,
    FundID NVARCHAR(50) NOT NULL,
    FOREIGN KEY (FundID) REFERENCES Funds(FundID)
);

-- Bảng Transactions (Giao dịch)
CREATE TABLE Transactions (
    TransactionID NVARCHAR(50) PRIMARY KEY,
    PortfolioID NVARCHAR(50) NOT NULL,
    TransactionDate DATE NOT NULL,
    TransactionType NVARCHAR(50) NOT NULL CHECK (TransactionType IN (N'Mua', N'Bán', N'Nạp tiền', N'Rút tiền')),
    Amount BIGINT NOT NULL,
    Description NVARCHAR(255) NOT NULL,
    FOREIGN KEY (PortfolioID) REFERENCES Portfolios(PortfolioID)
);

-- Bảng Performance (Hiệu suất quỹ)
CREATE TABLE Performance (
    PerformanceID NVARCHAR(50) PRIMARY KEY,
    FundID NVARCHAR(50) NOT NULL,
    Date DATE NOT NULL,
    NetAssetValue BIGINT NOT NULL,
    ReturnRate FLOAT NOT NULL,
    FOREIGN KEY (FundID) REFERENCES Funds(FundID)
);

-- Bảng RiskAssessment (Đánh giá rủi ro)
CREATE TABLE RiskAssessment (
    AssessmentID NVARCHAR(50) PRIMARY KEY,
    PortfolioID NVARCHAR(50) NOT NULL,
    AssetID NVARCHAR(50) NOT NULL,
    RiskScore INT NOT NULL,
    Comments NVARCHAR(255) NOT NULL,
    FOREIGN KEY (PortfolioID) REFERENCES Portfolios(PortfolioID),
    FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
);

-- Bảng Dividends (Cổ tức)
CREATE TABLE Dividends (
    DividendID NVARCHAR(50) PRIMARY KEY,
    FundID NVARCHAR(50) NOT NULL,
    PortfolioID NVARCHAR(50) NOT NULL,
    DividendDate DATE NOT NULL,
    Amount BIGINT NOT NULL,
    FOREIGN KEY (FundID) REFERENCES Funds(FundID),
    FOREIGN KEY (PortfolioID) REFERENCES Portfolios(PortfolioID)
);

-- Bảng AuditLogs (Nhật ký kiểm toán)
CREATE TABLE AuditLogs (
    LogID NVARCHAR(50) PRIMARY KEY,
    Timestamp DATETIME NOT NULL,
    UserID INT NOT NULL,
    ActionType NVARCHAR(50) NOT NULL CHECK (ActionType IN ('Create', 'Update', 'Delete')),
    Details NVARCHAR(255) NOT NULL
);
