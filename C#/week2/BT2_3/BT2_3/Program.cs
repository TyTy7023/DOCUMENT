using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BT2_3
{
    /*var: kiểu khai báo đặc biệt, được xác định kiểu dữ liệu dựa trên biến được gán vào 
     * Trong C++ có một từ khoá là auto tương tự như var trong C# */
    /*foreach(var biến in array): vòng lặp for theo biến tuần tự */

    /*Nhập 2 ma trận cùng kích thước, tính tổng hiệu và ìn ra kết quả */
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Console.WriteLine("Nhập kích thước ma trận");
            Console.Write("Số dòng: ");
            int rows = int.Parse(Console.ReadLine());

            Console.Write("Số cột: ");
            int cols = int.Parse(Console.ReadLine());

            int[,] matrix1 = new int[rows, cols];
            int[,] matrix2 = new int[rows, cols];
            int[,] sumMatrix = new int[rows, cols];
            int[,] diffMatrix = new int[rows, cols];

            // Nhập ma trận 1
            Console.WriteLine("Nhập ma trận 1:");
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    Console.Write($"matrix1[{i},{j}]: ");
                    matrix1[i, j] = int.Parse(Console.ReadLine());
                }
            }

            // Nhập ma trận 2
            Console.WriteLine("Nhập ma trận 2:");
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    Console.Write($"matrix2[{i},{j}]: ");
                    matrix2[i, j] = int.Parse(Console.ReadLine());
                }
            }

            // Tính tổng và hiệu của hai ma trận
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    sumMatrix[i, j] = matrix1[i, j] + matrix2[i, j];
                    diffMatrix[i, j] = matrix1[i, j] - matrix2[i, j];
                }
            }

            // In ma trận tổng
            Console.WriteLine("Tổng của hai ma trận:");
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                    Console.Write(sumMatrix[i, j] + "\t");
                Console.WriteLine();
            }

            // In ma trận hiệu
            Console.WriteLine("Hiệu của hai ma trận:");
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                    Console.Write(diffMatrix[i, j] + "\t");
                Console.WriteLine();
            }

            Console.ReadLine();

        }
    }
}
