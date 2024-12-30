using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    public class TEST
    {
        public static void Main(string[] args)
        {
            int a = 0;
            cong(a);

            Console.ReadLine();
        }

        public static void cong(int a)
        {
            Console.WriteLine(a+1);
        }

        public static void cong(hi a)
        {
            Console.WriteLine(a.a++);
        }
    }
    public class hi
    {
        public int a { get; set; }

        public hi(int a)
        {
            this.a = a;
        }
    }
}
