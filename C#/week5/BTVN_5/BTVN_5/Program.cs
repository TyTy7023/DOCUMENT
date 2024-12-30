using System;
using System.Collections.Generic;

namespace BTVN_5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            Manager manager = new Manager();

            manager.themGiaSuc(new BO(true));  // đực
            manager.themGiaSuc(new BO(false)); // cái
            manager.themGiaSuc(new DE(true));  
            manager.themGiaSuc(new DE(false)); 
            manager.themGiaSuc(new CUU(true)); 
            manager.themGiaSuc(new CUU(false));

            manager.doiAn();
            manager.thongKe();

            Console.ReadLine();
        }

        public abstract class GIA_SUC
        {
            public bool GioiTinh { get; protected set; }
            public string tenLoai { get; protected set; }

            public GIA_SUC() { }

            public abstract string tiengKeu();
            public abstract int tieuThu();
            public abstract int choSua();
            public int deCon()
            {
                Random random = new Random();
                return random.Next(1, 4);
            }
        }

        public class DE : GIA_SUC
        {
            public DE(bool GioiTinh)
            {
                this.tenLoai = "Dê";
                this.GioiTinh = GioiTinh;
            }

            public override string tiengKeu() => "Be Be";

            public override int tieuThu() => new Random().Next(1, 3);

            public override int choSua() => new Random().Next(2, 5);
        }

        public class BO : GIA_SUC
        {
            public BO(bool GioiTinh)
            {
                this.tenLoai = "Bò";
                this.GioiTinh = GioiTinh;
            }

            public override string tiengKeu() => "Uhm bò";

            public override int tieuThu() => new Random().Next(1, 6);

            public override int choSua() => new Random().Next(5, 11);
        }

        public class CUU : GIA_SUC
        {
            public CUU(bool GioiTinh)
            {
                this.tenLoai = "Cừu";
                this.GioiTinh = GioiTinh;
            }

            public override string tiengKeu() => "Cừu kêu";

            public override int tieuThu() => new Random().Next(1, 4);

            public override int choSua() => new Random().Next(3, 7);
        }

        public class Manager
        {
            List<GIA_SUC> giaSuc = new List<GIA_SUC>();

            public Manager() { }

            public void themGiaSuc(GIA_SUC giaSuc)
            {
                this.giaSuc.Add(giaSuc);
            }

            public void doiAn()
            {
                for (int i = 0; i < this.giaSuc.Count; i++)
                {
                    Console.WriteLine($"{this.giaSuc[i].tenLoai}: {this.giaSuc[i].tiengKeu()}");
                }
            }
            public void thongKe()
            {
                foreach (var animal in giaSuc)
                {
                    Console.WriteLine($"{animal.tenLoai}:");
                    Console.WriteLine($"- Tiếng kêu: {animal.tiengKeu()}");
                    Console.WriteLine($"- Số lượng thức ăn tiêu thụ: {animal.tieuThu()} kg");

                    if (!animal.GioiTinh) // Chỉ gia súc cái mới đẻ con và cho sữa
                    {
                        Console.WriteLine($"- Số con đẻ ra: {animal.deCon()}");
                        Console.WriteLine($"- Số lượng sữa cho: {animal.choSua()} lít");
                    }

                    Console.WriteLine(); // Dòng trống ngăn cách giữa các con vật
                }
            }
        }
    }
}
