using System;
using System.Text;

namespace BT2_1
{
    // Nhap vao h ve tam giac duoi cua ma tran h 
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Console.Write("Nhập h: ");
            int h = int.Parse(Console.ReadLine());

            for (int i = 0; i < h; i++)
            {
                for (int j = 0; j <= i; j++)
                    Console.Write("*\t");
                Console.WriteLine("\n");
            }

            Console.ReadLine();

        }
    }
}
