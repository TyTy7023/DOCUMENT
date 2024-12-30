using System;
using System.Net.Mime;
using System.Text;

namespace BT2_2
{
    /*  Khai báo mảng trong C#
     *  Kiểu_Dl[] biến ( = new kiểu_DL(); )
     *  int[] a = new int[] (1, 2, 3, 4)  */

    /* viết chương trình consoler nhập vào mảng số thực
     * Tính các đại lượng thống kê
     * - Trung bình
     * - Phương sai
     * - Trung vị */
    internal class Program
    {  
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Console.Write("Nhập n : ");
            int length = int.Parse(Console.ReadLine());

            float[] array = new float[length];
            for (int i = 0; i < length; i++)
            {
                float value = float.Parse(Console.ReadLine());
                array[i] = value;
            }
            Console.Write("Mảng đã nhập: ");
            for (int i = 0;i < length; i++)
                Console.Write(array[i] + " ");

            float mean = 0;
            for (int i = 0; i < length; i++)
                mean += array[i];
            mean /= length;
            Console.Write("\nTrung bình: " + mean);

            double variance= 0;
            for (int i = 0; i < length; i++)
                variance += Math.Pow((double)(array[i] - mean), 2);
            variance /= length;
            Console.Write("\nPhương sai: " + variance);

            float median = 0;
            for (int i = 0; i < length - 1; i++)
                for (int j = i; j < length; j++)
                {
                    if (array[i] > array[j])
                    {
                        float temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }

            int pos = length / 2;
            if (length % 2 == 0)
                median = array[pos];
            else 
                median = (array[pos] + array[pos + 1]) / 2 ;
            Console.Write("\nTrung vị : " + median);
                
            Console.ReadLine();
        }
    }
}
