using System;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace BTVN_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;

            soAo a = new soAo(1, 2);
            soAo b = new soAo(3, 4);

            Console.WriteLine($"Công hai só ảo: {a.toString()} + {b.toString()} = {soAo.sum(a, b).toString()}");
            Console.WriteLine($"Trừ hai só ảo: {a.toString()} - {b.toString()} = {soAo.sub(a, b).toString()}");

            Console.ReadLine();

        }
        public class soAo
        {
            public float a { get; set; }
            public float b { get; set; }

            public soAo() { 
                this.a = 0;
                this.b = 1.0f;
            }
            public soAo(float a, float b)
            {
                this.a = a;
                this.b = b;
            }

            static public soAo sum(soAo s1, soAo s2)
            {
                return new soAo(s1.a + s2.a, s1.b + s2.b);
            }

            static public soAo sub(soAo s1, soAo s2)
            {
                return new soAo(s1.a - s2.a, s1.b - s2.b);
            }

            public String toString() {
                return $"({this.a} + {this.b}i)";
            }

        }
    }
}
