
---

# 🎓 HƯỚNG DẪN SỬ DỤNG TRIGGER TRONG SQL SERVER

---

## 🧱 1. TRIGGER LÀ GÌ?

**Trigger** là một đoạn mã SQL đặc biệt, **tự động được thực thi** khi có sự kiện `INSERT`, `UPDATE`, hoặc `DELETE` xảy ra trên một bảng hoặc view.

**Ứng dụng của Trigger:**

* Kiểm tra ràng buộc nghiệp vụ (business rule).
* Tự động ghi log thay đổi dữ liệu.
* Ngăn chặn dữ liệu không hợp lệ.
* Thực hiện hành động đồng bộ trên nhiều bảng.

---

## 🛠️ 2. CÚ PHÁP TẠO TRIGGER CƠ BẢN

```sql
CREATE TRIGGER ten_trigger
ON ten_bang
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    -- Các câu lệnh kiểm tra / xử lý
END
```

> 📌 Có 2 loại:

* `AFTER` Trigger: Kích hoạt sau khi thao tác xảy ra.
* `INSTEAD OF` Trigger: Thay thế thao tác gốc (dùng chủ yếu cho View).

---

## 🧪 3. CÁC BẢNG ẢO TRONG TRIGGER

Khi Trigger được kích hoạt, **SQL Server tạo 2 bảng ảo:**

| Tên bảng   | Ý nghĩa                               |
| ---------- | ------------------------------------- |
| `inserted` | Dữ liệu mới (khi INSERT hoặc UPDATE). |
| `deleted`  | Dữ liệu cũ (khi DELETE hoặc UPDATE).  |

---

## 🔰 4. VÍ DỤ CƠ BẢN

### Ví dụ: Kiểm tra `NgayGiao` phải lớn hơn `NgayHD`

Giả sử bạn có 2 bảng:

```sql
-- Bảng hóa đơn
CREATE TABLE HOADON (
    SOHD CHAR(10) PRIMARY KEY,
    NGAYHD DATE
);

-- Bảng phiếu giao hàng
CREATE TABLE PHIEUGIAOHANG (
    SOPHIEU CHAR(10) PRIMARY KEY,
    SOHD CHAR(10),
    NGAYGIAO DATE
);
```

### Tạo Trigger kiểm tra ràng buộc:

```sql
CREATE TRIGGER TRG_NGAYGIAO_NGAYHD
ON PHIEUGIAOHANG
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM inserted i
        JOIN HOADON h ON i.SOHD = h.SOHD
        WHERE i.NGAYGIAO < h.NGAYHD
    )
    BEGIN
        RAISERROR(N'Ngày giao phải sau ngày hóa đơn', 16, 1);
        ROLLBACK TRANSACTION;
        RETURN;
    END
END;
```

---

## 💡 5. PHÂN BIỆT CÁC TÌNH HUỐNG TRONG TRIGGER

| Loại thao tác | `inserted` | `deleted` |
| ------------- | ---------- | --------- |
| `INSERT`      | Có         | Không     |
| `DELETE`      | Không      | Có        |
| `UPDATE`      | Có         | Có        |

---

## 🔄 6. TRIGGER NÂNG CAO

### a. **Không cho phép giảm lương nhân viên**

```sql
CREATE TRIGGER TRG_KIEMTRA_LUONG
ON NHANVIEN
FOR UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM inserted i
        JOIN deleted d ON i.ID = d.ID
        WHERE i.LUONG < d.LUONG
    )
    BEGIN
        RAISERROR(N'Không được giảm lương nhân viên!', 16, 1);
        ROLLBACK;
        RETURN;
    END
END;
```

---

### b. **Ghi log khi cập nhật**

```sql
CREATE TABLE LOGNHANVIEN (
    ID INT IDENTITY,
    HANHDONG NVARCHAR(100),
    NGAYTHUCHIEN DATETIME
);

CREATE TRIGGER TRG_LOG_UPDATE
ON NHANVIEN
AFTER UPDATE
AS
BEGIN
    INSERT INTO LOGNHANVIEN(HANHDONG, NGAYTHUCHIEN)
    SELECT CONCAT('Cập nhật nhân viên ID = ', ID), GETDATE()
    FROM inserted;
END;
```

---

## 🧹 7. QUẢN LÝ TRIGGER

| Hành động          | Lệnh SQL                                     |
| ------------------ | -------------------------------------------- |
| Xem trigger đã tạo | `SELECT * FROM sys.triggers`                 |
| Xem mã trigger     | `sp_helptext 'ten_trigger'`                  |
| Xóa trigger        | `DROP TRIGGER ten_trigger`                   |
| Tắt / bật trigger  | `DISABLE TRIGGER ...` / `ENABLE TRIGGER ...` |

---

## 🚨 8. CẢNH BÁO & KINH NGHIỆM

* Tránh viết trigger quá phức tạp → làm chậm hệ thống.
* Không nên dùng trigger để thay thế toàn bộ nghiệp vụ.
* Cẩn thận khi cập nhật nhiều dòng (nên dùng `EXISTS`, `JOIN` thay vì biến đơn).

---

## 📚 9. ÔN TẬP

| Kiến thức          | Gợi ý thực hành                                    |
| ------------------ | -------------------------------------------------- |
| Cú pháp Trigger    | Tạo trigger khi thêm dữ liệu vào bảng              |
| Kiểm tra nghiệp vụ | So sánh dữ liệu `inserted` và `deleted`            |
| Bảng ảo            | Hiểu rõ `inserted`, `deleted` trong các trường hợp |
| Trigger nhiều dòng | Dùng `JOIN`, `EXISTS` thay vì biến đơn             |

---

Bạn có muốn mình tạo thêm bài tập thực hành hoặc mẫu đề thi liên quan đến Trigger không? Mình có thể cung cấp luôn!
