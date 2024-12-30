using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BT2_VN
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Console.Write("Nhập số cần đọc: ");
            int number = int.Parse(Console.ReadLine());
            Console.WriteLine(number);

            string[] read = new string[100];
            int i = 0;
            while (number > 0)
            {
                switch (number%10) {
                    case 0:
                        read[i] = "";
                        break;
                    case 1:
                        read[i] = "một";
                        break;
                    case 2:
                        read[i] = "hai";
                        break;
                    case 3:
                        read[i] = "ba";
                        break;
                    case 4:
                        read[i] = "bốn";
                        break;
                    case 5:
                        read[i] = "năm";
                        break;
                    case 6:
                        read[i] = "sáu";
                        break;
                    case 7:
                        read[i] = "bảy";
                        break;
                    case 8:
                        read[i] = "tám";
                        break;
                    case 9:
                        read[i] = "chín";
                        break;
                }
                i += 2;
                number /= 10;
            }
            i -= 2;
            for(int j = 1; j < i; j++)
            {
                switch (j)
                {
                    case 1:
                    case 7:
                        if(j+1 == i && read[i].Equals("một")){
                            read[j] = " mười ";
                            i--;
                            break;
                        }
                        if(read[j+1] !="" )
                            read[j] = " mươi ";
                        break;
                    case 3:
                    case 9:
                        if (read[j + 1] != "")
                            read[j] = " trăm ";
                        break;
                    case 5:
                            read[j] = " ngàn ";
                        break;
                    case 11:
                            read[j] = " tỷ ";
                        break;
                }
            }

        for (int j = i; j >= 0; j--)
            {
                Console.Write(read[j]);
            }
        Console.ReadKey();
        }
    }
}
