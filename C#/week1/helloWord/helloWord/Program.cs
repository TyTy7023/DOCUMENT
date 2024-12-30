using System;
using System.Text;

namespace helloWord
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;

            Console.Write("Nhập r 1: ");
            string radius_1 = Console.ReadLine();
            // Thử chuyển chuỗi thành số thực
            if (!double.TryParse(radius_1, out double r_1) || r_1 <= 0)
            {
                // Nếu chuyển đổi thành công
                Console.WriteLine("không phải Số hợp lệ");
                Console.ReadKey();
                return;
            }

            Console.Write("Nhập r 2: ");
            string radius_2 = Console.ReadLine();
            // Thử chuyển chuỗi thành số thực
            if (!double.TryParse(radius_1, out double r_2) || r_2 < r_1)
            {
                // Nếu chuyển đổi thành công
                Console.WriteLine("không phải Số hợp lệ");
                Console.ReadKey();
                return;
            }

            Console.Write("Nhập n: ");
            string num = Console.ReadLine(); 
            if (!int.TryParse(num, out int n) || n <= 3)
            {
                // Nếu chuyển đổi thành công
                Console.WriteLine("không phải Số nguyên");
                Console.ReadKey();
                return;
            }

            double area_1 = Area(n,r_1);
            double area_2 = Area(n, r_2);
            Console.WriteLine("Kết quả: " + (area_2 - area_1) );

            Console.ReadKey();
        }
        static double Area(int n, double r)
        {
            return 0.5 * n * r * r * Math.Sin(2 * Math.PI / n);
        }
    }  
}
