USE InvestmentManagement;
GO
-- Chèn dữ liệu vào bảng Managers
INSERT INTO Managers (ManagerID, Name, Email, Phone, ExperienceYears, Description)
VALUES
(N'MG001', N'Nguyễn Văn A', N'vana@example.com', N'0901234567', 10, N'Chuyên gia quản lý quỹ cổ phiếu'),
(N'MG002', N'Trần Thị B', N'thib@example.com', N'0912345678', 8, N'Chuyên gia trái phiếu'),
(N'MG003', N'Lê Hoàng C', N'hoangc@example.com', N'0923456789', 15, N'Chiến lược gia đầu tư hỗn hợp'),
(N'MG004', N'Phạm Duy D', N'duyd@example.com', N'0934567890', 12, N'Quản lý danh mục cao cấp'),
(N'MG005', N'Bùi Văn E', N'vane@example.com', N'0945678901', 9, N'Chuyên viên phân tích rủi ro'),
(N'MG006', N'Hoàng Thị F', N'thif@example.com', N'0956789012', 7, N'Nhà tư vấn đầu tư cá nhân'),
(N'MG007', N'Đinh Công G', N'congg@example.com', N'0967890123', 11, N'Quản lý danh mục quỹ hưu trí'),
(N'MG008', N'Ngô Hải H', N'haih@example.com', N'0978901234', 14, N'Chiến lược gia quỹ ETF'),
(N'MG009', N'Vũ Thanh I', N'thanhi@example.com', N'0989012345', 6, N'Chuyên viên tài chính cá nhân'),
(N'MG010', N'Phan Minh J', N'minhj@example.com', N'0990123456', 13, N'Quản lý danh mục tài sản lớn');

-- Chèn dữ liệu vào bảng Clients
INSERT INTO Clients (ClientID, Name, Email, Phone, Address, RiskProfile, AccountBalance, DateCreated)
VALUES
(N'CL001', N'Nguyễn Văn Khánh', N'khanh@example.com', N'0901111111', N'Hà Nội', N'Thấp', 50000000, '2023-01-01'),
(N'CL002', N'Lê Thị Hương', N'huong@example.com', N'0911222222', N'Đà Nẵng', N'Trung bình', 200000000, '2023-02-01'),
(N'CL003', N'Trần Minh Long', N'long@example.com', N'0921333333', N'Hồ Chí Minh', N'Cao', 1000000000, '2023-03-01'),
(N'CL004', N'Phạm Thanh Sơn', N'son@example.com', N'0931444444', N'Đà Nẵng', N'Thấp', 70000000, '2023-04-01'),
(N'CL005', N'Hoàng Văn Quang', N'quang@example.com', N'0941555555', N'Hồ Chí Minh', N'Trung bình', 300000000, '2023-05-01'),
(N'CL006', N'Võ Thị Lan', N'lan@example.com', N'0951666666', N'Đà Nẵng', N'Cao', 1200000000, '2023-06-01'),
(N'CL007', N'Bùi Hoài Nam', N'nam@example.com', N'0961777777', N'Hà Nội', N'Thấp', 60000000, '2023-07-01'),
(N'CL008', N'Ngô Minh Đức', N'duc@example.com', N'0971888888', N'Đà Nẵng', N'Trung bình', 400000000, '2023-08-01'),
(N'CL009', N'Vũ Thanh An', N'an@example.com', N'0981999999', N'Hà Nội', N'Cao', 1500000000, '2023-09-01'),
(N'CL010', N'Phan Bảo Châu', N'chau@example.com', N'0992000000', N'Hồ Chí Minh', N'Thấp', 80000000, '2023-10-01');

-- Chèn dữ liệu vào bảng Funds
INSERT INTO Funds (FundID, FundName, FundType, StartDate, TotalAssets, ManagerID, PerformanceFee, ManagementFee)
VALUES
(N'FD001', N'Quỹ Cổ phiếu A', N'Cổ phiếu', '2020-01-01', 5000000000, N'MG001', 1.5, 2.0),
(N'FD002', N'Quỹ Trái phiếu B', N'Trái phiếu', '2019-06-15', 3000000000, N'MG002', 1.0, 1.5),
(N'FD003', N'Quỹ Hỗn hợp C', N'Hỗn hợp', '2021-03-10', 4000000000, N'MG003', 1.8, 2.2),
(N'FD004', N'Quỹ ETF D', N'Cổ phiếu', '2018-09-20', 6000000000, N'MG004', 1.2, 1.8),
(N'FD005', N'Quỹ Hưu trí E', N'Trái phiếu', '2022-05-05', 2500000000, N'MG005', 1.0, 1.3),
(N'FD006', N'Quỹ Đầu tư F', N'Hỗn hợp', '2020-11-11', 3500000000, N'MG006', 1.7, 2.0),
(N'FD007', N'Quỹ Phát triển G', N'Cổ phiếu', '2017-07-07', 7000000000, N'MG007', 1.4, 1.9),
(N'FD008', N'Quỹ Cân bằng H', N'Hỗn hợp', '2019-12-12', 4500000000, N'MG008', 1.6, 2.1),
(N'FD009', N'Quỹ Công nghệ I', N'Cổ phiếu', '2021-08-08', 5500000000, N'MG009', 1.9, 2.3),
(N'FD010', N'Quỹ Bất động sản J', N'Trái phiếu', '2016-04-04', 8000000000, N'MG010', 1.3, 1.7);

-- Chèn dữ liệu vào bảng Portfolios (Danh mục đầu tư)
INSERT INTO Portfolios (PortfolioID, ClientID, FundID, RiskLevel, StartDate, Value)
VALUES
(N'P001', N'CL001', N'FD001', 3, '2023-01-05', 10000000),
(N'P002', N'CL002', N'FD002', 5, '2023-02-10', 20000000),
(N'P003', N'CL003', N'FD003', 7, '2023-03-15', 30000000),
(N'P004', N'CL004', N'FD004', 4, '2023-04-20', 40000000),
(N'P005', N'CL005', N'FD005', 6, '2023-05-25', 50000000),
(N'P006', N'CL006', N'FD006', 8, '2023-06-30', 60000000),
(N'P007', N'CL007', N'FD007', 5, '2023-07-05', 70000000),
(N'P008', N'CL008', N'FD008', 3, '2023-08-10', 80000000),
(N'P009', N'CL009', N'FD009', 7, '2023-09-15', 90000000),
(N'P010', N'CL010', N'FD010', 4, '2023-10-20', 100000000);

-- Chèn dữ liệu vào bảng Assets (Tài sản)
INSERT INTO Assets (AssetID, AssetName, AssetType, MarketValue, RiskLevel, FundID)
VALUES
(N'A001', N'Cổ phiếu VNM', N'Cổ phiếu', 120000, 3, N'FD001'),
(N'A002', N'Trái phiếu CP', N'Trái phiếu', 100000, 2, N'FD002'),
(N'A003', N'Bất động sản A', N'Bất động sản', 500000000, 4, N'FD003'),
(N'A004', N'Cổ phiếu FPT', N'Cổ phiếu', 95000, 2, N'FD004'),
(N'A005', N'Trái phiếu TCB', N'Trái phiếu', 105000, 3, N'FD005'),
(N'A006', N'Bất động sản B', N'Bất động sản', 600000000, 5, N'FD006'),
(N'A007', N'Cổ phiếu VIC', N'Cổ phiếu', 110000, 3, N'FD007'),
(N'A008', N'Trái phiếu BID', N'Trái phiếu', 102000, 2, N'FD008'),
(N'A009', N'Bất động sản C', N'Bất động sản', 700000000, 4, N'FD009'),
(N'A010', N'Cổ phiếu HPG', N'Cổ phiếu', 90000, 2, N'FD010');


-- Chèn dữ liệu vào bảng RiskAssessment (Đánh giá rủi ro)
INSERT INTO RiskAssessment (AssessmentID, PortfolioID, AssetID, RiskScore, Comments)
VALUES
(N'RA001', N'P001', N'A001', 7, N'Cổ phiếu có độ biến động cao'),
(N'RA002', N'P002', N'A002', 4, N'Trái phiếu có độ an toàn trung bình'),
(N'RA003', N'P003', N'A003', 6, N'Bất động sản có tính ổn định'),
(N'RA004', N'P004', N'A004', 8, N'Cổ phiếu công nghệ có rủi ro cao'),
(N'RA005', N'P005', N'A005', 5, N'Trái phiếu ổn định nhưng lợi suất thấp'),
(N'RA006', N'P006', N'A006', 7, N'Bất động sản có tiềm năng tăng trưởng'),
(N'RA007', N'P007', N'A007', 9, N'Cổ phiếu tập đoàn có rủi ro trung bình cao'),
(N'RA008', N'P008', N'A008', 3, N'Trái phiếu ngân hàng ít rủi ro'),
(N'RA009', N'P009', N'A009', 6, N'Bất động sản thương mại có giá trị lớn'),
(N'RA010', N'P010', N'A010', 7, N'Cổ phiếu ngành thép có biến động mạnh');

-- Chèn dữ liệu vào bảng Performance (Hiệu suất quỹ)
INSERT INTO Performance (PerformanceID, FundID, Date, NetAssetValue, ReturnRate)
VALUES
(N'PF001', N'FD001', '2023-01-31', 5000000000, 5.2),
(N'PF002', N'FD002', '2023-02-28', 3000000000, 3.8),
(N'PF003', N'FD003', '2023-03-31', 4000000000, 4.5),
(N'PF004', N'FD004', '2023-04-30', 6000000000, 6.0),
(N'PF005', N'FD005', '2023-05-31', 2500000000, 2.7),
(N'PF006', N'FD006', '2023-06-30', 3500000000, 3.9),
(N'PF007', N'FD007', '2023-07-31', 7000000000, 5.5),
(N'PF008', N'FD008', '2023-08-31', 4500000000, 4.8),
(N'PF009', N'FD009', '2023-09-30', 5500000000, 5.1),
(N'PF010', N'FD010', '2023-10-31', 8000000000, 6.3);

-- Chèn dữ liệu vào bảng Dividends (Cổ tức)
INSERT INTO Dividends (DividendID, FundID, PortfolioID, DividendDate, Amount)
VALUES
(N'DV001', N'FD001', N'P001', '2023-01-31', 2000000),
(N'DV002', N'FD002', N'P002', '2023-02-28', 1500000),
(N'DV003', N'FD003', N'P003', '2023-03-31', 2500000),
(N'DV004', N'FD004', N'P004', '2023-04-30', 3000000),
(N'DV005', N'FD005', N'P005', '2023-05-31', 1800000),
(N'DV006', N'FD006', N'P006', '2023-06-30', 2100000),
(N'DV007', N'FD007', N'P007', '2023-07-31', 2800000),
(N'DV008', N'FD008', N'P008', '2023-08-31', 2400000),
(N'DV009', N'FD009', N'P009', '2023-09-30', 2600000),
(N'DV010', N'FD010', N'P010', '2023-10-31', 3100000);

-- Chèn dữ liệu vào bảng Transactions
INSERT INTO Transactions (TransactionID, PortfolioID, TransactionDate, TransactionType, Amount, Description)
VALUES
(N'TR001', N'P001', '2023-01-10', N'Mua', 10000000, N'Mua cổ phiếu A'),
(N'TR002', N'P002', '2023-02-15', N'Bán', 5000000, N'Bán trái phiếu B'),
(N'TR003', N'P003', '2023-03-20', N'Nạp tiền', 20000000, N'Nạp tiền vào danh mục C'),
(N'TR004', N'P004', '2023-04-25', N'Rút tiền', 15000000, N'Rút tiền từ danh mục D'),
(N'TR005', N'P005', '2023-05-30', N'Mua', 12000000, N'Mua cổ phiếu E'),
(N'TR006', N'P006', '2023-06-10', N'Bán', 8000000, N'Bán cổ phiếu F'),
(N'TR007', N'P007', '2023-07-15', N'Nạp tiền', 25000000, N'Nạp tiền vào danh mục G'),
(N'TR008', N'P008', '2023-08-20', N'Rút tiền', 18000000, N'Rút tiền từ danh mục H'),
(N'TR009', N'P009', '2023-09-25', N'Mua', 14000000, N'Mua cổ phiếu I'),
(N'TR010', N'P010', '2023-10-30', N'Bán', 7000000, N'Bán trái phiếu J');

-- Chèn dữ liệu vào bảng AuditLogs (Nhật ký kiểm toán)
INSERT INTO AuditLogs (LogID, Timestamp, UserID, ActionType, Details)
VALUES
(N'LG001', '2023-01-01 10:00:00', 1, 'Create', N'Tạo mới khách hàng CL001'),
(N'LG002', '2023-02-02 11:30:00', 2, 'Update', N'Cập nhật số dư tài khoản CL002'),
(N'LG003', '2023-03-03 14:45:00', 3, 'Delete', N'Xóa danh mục P003'),
(N'LG004', '2023-04-04 16:20:00', 4, 'Create', N'Tạo mới quỹ FD004'),
(N'LG005', '2023-05-05 18:10:00', 5, 'Update', N'Cập nhật giá trị tài sản A005'),
(N'LG006', '2023-06-06 09:05:00', 6, 'Delete', N'Xóa giao dịch TR006'),
(N'LG007', '2023-07-07 13:25:00', 7, 'Create', N'Tạo mới quỹ FD007'),
(N'LG008', '2023-08-08 15:15:00', 8, 'Update', N'Cập nhật RiskScore RA008'),
(N'LG009', '2023-09-09 17:40:00', 9, 'Delete', N'Xóa cổ tức DV009'),
(N'LG010', '2023-10-10 20:55:00', 10, 'Create', N'Tạo mới tài sản A010');
