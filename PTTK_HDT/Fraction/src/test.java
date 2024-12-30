import java.util.Random;

public class test {
    private Fraction[] fractions;
    private int num; // Số phần tử hiện tại trong mảng

    // Constructor nhận số lượng phần tử và tạo mảng
    public test(int num) {
        this.num = num;
        this.fractions = new Fraction[100]; // Giả định mảng có kích thước tối đa là 100
        createArray(this.num);
    }

    // Constructor nhận mảng phân số
    public test(Fraction[] fractions) {
        this.fractions = fractions;
        this.num = fractions.length;
    }

    // Tạo mảng các phân số ngẫu nhiên
    public void createArray(int num) {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            Fraction f = new Fraction(rand.nextInt(10), rand.nextInt(10) + 1);
            this.fractions[i] = f;
        }
    }

    // Thêm phân số vào vị trí chỉ định
    public void addFrac(int pos, Fraction f) {
        if (pos < 0 || pos > num || num >= 100) {
            System.out.println("Invalid position or array full");
            return;
        }
        for (int i = num; i > pos; i--) {
            this.fractions[i] = this.fractions[i - 1];
        }
        this.fractions[pos] = f;
        num++; // Tăng số phần tử hiện tại
    }

    // Thêm phân số vào cuối mảng
    public void addFrac(Fraction f) {
        if (num >= 100) {
            System.out.println("Array full");
            return;
        }
        this.fractions[num] = f;
        num++;
    }

    // Xóa phân số tại vị trí chỉ định
    public int removeFrac(int pos) {
        if (pos < 0 || pos >= num) 
            return 0; // Vị trí không hợp lệ
        for (int i = pos; i < num - 1; i++) 
            this.fractions[i] = this.fractions[i + 1];
        this.fractions[num - 1] = null; // Xóa phần tử cuối cùng
        num--; // Giảm số phần tử hiện tại
        return 1;
    }

    // Xóa phân số bằng cách tìm kiếm phân số
    public int removeFrac(Fraction f) {
        for (int i = 0; i < num; i++) {
            if (this.fractions[i].compareTo(f) == 0) {
                removeFrac(i); // Gọi phương thức xóa tại vị trí
                return 1;
            }
        }
        return 0;
    }

    // Sắp xếp mảng phân số
    private void sort() {
        for (int i = 0; i < num - 1; i++) 
            for (int j = i + 1; j < num; j++) {
                if (fractions[i].compareTo(fractions[j]) > 0) {
                    Fraction temp = this.fractions[i];
                    this.fractions[i] = this.fractions[j];
                    this.fractions[j] = temp;
                }
            }
    }

    // Tìm phân số trong mảng
    public int findFraction(Fraction f) {
        for (int i = 0; i < num; i++) {
            if (this.fractions[i].compareTo(f) == 0) {
                return 1;
            }
        }
        return 0;
    }

    // Tìm phân số lớn nhất trong mảng
    public Fraction findMax() {
        sort(); // Sắp xếp trước khi tìm phần tử lớn nhất
        return this.fractions[num - 1];
    }

    // Hiển thị toàn bộ phân số trong mảng dưới dạng chuỗi
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < num; i++) {
            s += this.fractions[i] + "\t";
        }
        return s += "\n";
    }
}
