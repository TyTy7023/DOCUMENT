using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BT2_5
{
    internal class Program
    {
        static void Main(string[] args)
        {
        }
    }

    public abstract class HINH {
        protected string tenHinh;
        protected double chuVi;
        protected double dienTich;

        public abstract double tinhDienTich();
        public abstract double tinhChuVi();
    }

    public class HINH_CHU_NHAT : HINH {

        public double dai {  get; set; }
        public double rong { get; set; }  
        
        public HINH_CHU_NHAT(double dai, double rong)
        {
            this.tenHinh = "Hình Chữ Nhật";
            this.dai = dai;
            this.rong = rong;
            this.dienTich = tinhDienTich();
            this.chuVi = tinhChuVi();
        }

        public override double tinhDienTich() => dai * rong;
        public override double tinhChuVi() => (dai + rong) * 2;
    }

    public class HINH_VUONG : HINH
    {

        public double canh { get; set; }

        public HINH_VUONG(double canh)
        {
            this.tenHinh = "Hình Vuông";
            this.canh = canh;
            this.dienTich = tinhDienTich();
            this.chuVi = tinhChuVi();
        }

        public override double tinhDienTich() => canh * canh;
        public override double tinhChuVi() => canh * 4;
    }

    public class HINH_TRON : HINH
    {

        public double banKinh { get; set; }

        public HINH_TRON(double banKinh)
        {
            this.tenHinh = "Hình Tròn";
            this.banKinh = banKinh;
            this.dienTich = tinhDienTich();
            this.chuVi = tinhChuVi();
        }

        public override double tinhDienTich() => Math.PI * banKinh * banKinh;
        public override double tinhChuVi() => Math.PI * banKinh * 2;
    }

    public class HINH_ELIP : HINH
    {
        public double a { get; set; }
        public double b { get; set; }

        public HINH_ELIP(double a, double b)
        {
            this.tenHinh = "Hình Elip";
            this.a = a; // bán kính lớn
            this.b = b; // bán kính nhỏ
            this.dienTich = tinhDienTich();
            this.chuVi = tinhChuVi();
        }

        public override double tinhDienTich() => Math.PI * a * b;
        public override double tinhChuVi() => Math.PI * (3 * (a + b) - Math.Sqrt((3 * a + b) * (a + 3 * b)));
    }

    public class Manager
    {
        public List<HINH> danhSachHinh;
        public Manager() { }
    }
}
