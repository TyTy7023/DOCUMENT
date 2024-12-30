using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace bt1_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            bool i = true;
            string input = "";
            while (i)
            {                
                Console.WriteLine("Nhập ngày tháng năm (dd/mm/yyyy): ");
                input = Console.ReadLine();
                string pattern = @"^\d{2}/\d{2}/\d{4}$"; // Định dạng dd/MM/yyyy đơn giản
                if (Regex.IsMatch(input, pattern))
                    break;
                Console.WriteLine("không hợp lệ, nhập lại theo format dd/mm/yyyy");
            }

            int[] day = Array.ConvertAll(input.Split('/'), int.Parse);
            switch (day[1])
            {
                case 2:
                    bool isLeapYear = (day[2] % 400 == 0);
                    if (day[0] < 1 || (isLeapYear && day[0] > 29) || (!isLeapYear && day[0] > 28))
                    {
                        Console.WriteLine("Ngày không hợp lệ");
                        break;
                    }

                    if (isLeapYear && day[0] == 29)
                    {
                        Console.WriteLine("01/03/" + day[2]);
                        break;
                    }

                    if (!isLeapYear && day[0] == 28)
                    {
                        Console.WriteLine("01/03/" + day[2]);
                        break;
                    }

                    Console.WriteLine((day[0] + 1).ToString("D2") + "/02/" + day[2]);
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day[0] < 1 && day[0] > 31) {
                        Console.WriteLine("Ngày không hợp lệ");
                        break;
                    }
                    if (day[0] == 31)
                    {
                        if (day[1] == 12) {
                            Console.WriteLine("01/01/" + (day[2]+1));
                            break;
                        }
                        Console.WriteLine("01/" + (day[1] + 1).ToString("D2") + "/" + day[2]);
                        break;
                    }
                    Console.WriteLine((day[0] + 1).ToString("D2") + "/" + day[1].ToString("D2") + "/" + day[2]);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day[0] < 1 && day[0] > 30)
                    {
                        Console.WriteLine("Ngày không hợp lệ");
                        break;
                    }
                    if (day[0] == 30)
                    {
                        Console.WriteLine("01/" + (day[1] + 1).ToString("D2") + "/" + day[2]);
                        break;
                    }
                    Console.WriteLine((day[0] + 1).ToString("D2") + "/" + day[1].ToString("D2") + "/" + day[2]);
                    break;
                default:
                    Console.WriteLine("Bạn nhập sai tháng");
                    break;
            }

            Console.ReadKey();
        }
    }
}
