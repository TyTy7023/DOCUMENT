# KHÁI NIỆM
- Để tạo một **stored procedure (thủ tục lưu trữ)** trong SQL Server, bạn có thể làm theo từng cách tùy mục tiêu và độ phức tạp. Dưới đây là **tổng hợp và hướng dẫn từng cách tạo stored procedure** từ cơ bản đến nâng cao:

---

## ✅ **1. Stored Procedure đơn giản – Không tham số**

Dùng để thực hiện một tác vụ cố định như truy vấn hoặc cập nhật.

### 📌 Cú pháp:

```sql
CREATE PROCEDURE Ten_Procedure
AS
BEGIN
    -- Câu lệnh SQL
    SELECT * FROM BangDuLieu
END
```

### ✅ Ví dụ:

```sql
CREATE PROCEDURE sp_DanhSachNhaCungCap
AS
BEGIN
    SELECT * FROM NHACUNGCAP
END
```

---

## ✅ **2. Stored Procedure có tham số đầu vào (Input Parameter)**

### 📌 Cú pháp:

```sql
CREATE PROCEDURE Ten_Procedure
    @ThamSoKieu KieuDuLieu
AS
BEGIN
    -- Câu lệnh sử dụng tham số
END
```

### ✅ Ví dụ:

```sql
CREATE PROCEDURE sp_TimHangTheoMa
    @mahh char(10)
AS
BEGIN
    SELECT * FROM HANGHOA WHERE MAHH = @mahh
END
```

---

## ✅ **3. Stored Procedure có tham số đầu ra (Output Parameter)**

### 📌 Cú pháp:

```sql
CREATE PROCEDURE Ten_Procedure
    @Input KieuDuLieu,
    @Output KieuDuLieu OUTPUT
AS
BEGIN
    -- Gán giá trị cho @Output
END
```

### ✅ Ví dụ:

Tính tổng tiền của hóa đơn:

```sql
CREATE PROCEDURE sp_TongTienHoaDon
    @sohd char(10),
    @tongtien money OUTPUT
AS
BEGIN
    SELECT @tongtien = SUM(SOLUONG * DONGIA)
    FROM CTHOADON
    WHERE SOHD = @sohd
END
```

---

## ✅ **4. Stored Procedure có giá trị trả về (RETURN)**

### 📌 Cú pháp:

```sql
CREATE PROCEDURE Ten_Procedure
    @param KieuDuLieu
AS
BEGIN
    IF NOT EXISTS (SELECT * FROM ...)
        RETURN 0  -- thất bại
    RETURN 1      -- thành công
END
```

👉 Giá trị `RETURN` là kiểu `int`, thường dùng để báo hiệu thành công/thất bại.

### ✅ Ví dụ kết hợp:

```sql
CREATE PROCEDURE sp_KiemTraMaNCC
    @mancc char(10)
AS
BEGIN
    IF EXISTS (SELECT * FROM NHACUNGCAP WHERE MANCC = @mancc)
        RETURN 1
    ELSE
        RETURN 0
END
```

---

## ✅ **5. Gọi Stored Procedure**

### Không có tham số:

```sql
EXEC sp_DanhSachNhaCungCap
```

### Có tham số:

```sql
EXEC sp_TimHangTheoMa 'HH001'
```

### Có tham số đầu ra:

```sql
DECLARE @tongtien money
EXEC sp_TongTienHoaDon 'HD001', @tongtien OUTPUT
PRINT @tongtien
```

### Có giá trị `RETURN`:

```sql
DECLARE @kq int
EXEC @kq = sp_KiemTraMaNCC 'NCC01'
IF @kq = 1
    PRINT 'Tồn tại'
ELSE
    PRINT 'Không tồn tại'
```

---

## ✅ **6. Sửa hoặc xóa Stored Procedure**

### 🔁 Sửa:

```sql
ALTER PROCEDURE Ten_Procedure
-- Viết lại phần thân như khi tạo
```

### ❌ Xóa:

```sql
DROP PROCEDURE Ten_Procedure
```

---

Nếu bạn muốn mình hướng dẫn thêm về cách debug, kiểm tra lỗi, hay viết thủ tục phức tạp hơn (với `CURSOR`, `TRY...CATCH`, `TRANSACTION`), hãy nói rõ yêu cầu nhé.
