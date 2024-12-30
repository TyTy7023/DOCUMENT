using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BT1_7
{
    public delegate double MathOperation(double a, double b);
    internal class Program
    {
        public class Caculator
        {
            public static double add(double a, double b) => a + b;
            public static double sub(double a, double b) => a - b;
            public static double mul(double a, double b) => a * b;
            public static double div(double a, double b) => a / b;
        }
        static void Main(string[] args)
        {
            MathOperation operation;
            operation = Caculator.add;
            double result = operation(5, 3);
            Console.WriteLine(result);

            operation = Caculator.sub;
            double sub = operation(5, 3);
            Console.WriteLine(sub);

            operation = Caculator.mul;
            double mul = operation(5, 3);
            Console.WriteLine(mul);

            operation = Caculator.div;
            double div = operation(5, 3);
            Console.WriteLine(div);

            Console.ReadLine();

        }
    }
}
