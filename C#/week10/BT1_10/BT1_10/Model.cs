using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Threading.Tasks;

namespace BT1_10
{
    internal class Model
    {
        public static double add(double x, double y) => x + y; 

        public static double sub(double x, double y) => x - y;

        public static double mul(double x, double y) => x * y;

        public static double div(double x, double y)
        {
            if (x == 0 && y == 0) return double.NaN;
            if (y == 0) return double.NaN;
            return x / y;
        }

        public static double reciprocal_function(double x)
        {
            if (x==0) return double.NaN;
            return 1/ x;
        }

        public static double sqrt(double x)
        {
            if (x< 0) return double.NaN;
            return Math.Sqrt(x);
        }

        public static double pow(double x) => x * x;

        public static double negative(double x) => -x;

    }
}
