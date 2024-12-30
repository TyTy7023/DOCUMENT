using System;

namespace BTVN_4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.Write("NHAP SO DONG: ");
            int row = int.Parse(Console.ReadLine());
            Console.Write("NHAP SO COT: ");
            int col = int.Parse(Console.ReadLine());

            MATRIX A = new MATRIX(row, col,new Random(42));
            MATRIX B = new MATRIX(row, col, new Random(15));

            Console.WriteLine("MA TRAM A: "); A.display();
            Console.WriteLine("MA TRAM B: "); B.display();

            Console.WriteLine("CONG: "); (A + B).display();
            Console.WriteLine("TRU: "); (A - B).display();
            Console.WriteLine("NHAN: "); (A * B).display();
            Console.WriteLine("CHIA: "); (A / B).display();

            Console.ReadLine();
        }

        public class MATRIX
        {
            public int R { get; set; }
            public int C { get; set; }
            public double[,] matrix { get; set; }

            public MATRIX(int r, int c, Random rand)
            {
                this.R = r;
                this.C = c;
                this.matrix = createMatrix(rand);
            }
            public MATRIX(int r, int c)
            {
                this.R = r;
                this.C = c;
                this.matrix = new double[R,C];
            }

            private double[,] createMatrix(Random rand)
            {
                double[,] matrix = new double[R, C];
                for (int i = 0; i < R; i++)
                    for (int j = 0; j < C; j++)
                        matrix[i, j] = rand.NextDouble();
                return matrix;
            }

            public static MATRIX operator +(MATRIX left, MATRIX right)
            {
                if (left.R != right.R || left.C != right.C)
                    throw new InvalidOperationException("Kích thước ma trận không hợp lệ.");

                MATRIX result = new MATRIX(left.R, left.C);
                for (int i = 0; i < left.R; i++)
                    for (int j = 0; j < left.C; j++)
                        result.matrix[i, j] = left.matrix[i, j] + right.matrix[i, j];
                return result;
            }

            public static MATRIX operator -(MATRIX left, MATRIX right)
            {
                if (left.R != right.R || left.C != right.C)
                    throw new InvalidOperationException("Kích thước ma trận không hợp lệ.");

                MATRIX result = new MATRIX(left.R, left.C);
                for (int i = 0; i < left.R; i++)
                    for (int j = 0; j < left.C; j++)
                        result.matrix[i, j] = left.matrix[i, j] - right.matrix[i, j];
                return result;
            }

            public static MATRIX Inverse(MATRIX matrix)
            {
                int n = matrix.R;
                if (matrix.R != matrix.C)
                    throw new InvalidOperationException("Ma trận phải là ma trận vuông.");

                double[,] augmented = new double[n, 2 * n];
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < n; j++) augmented[i, j] = matrix.matrix[i, j];
                    augmented[i, i + n] = 1.0;
                }

                for (int i = 0; i < n; i++)
                {
                    double pivot = augmented[i, i];
                    if (Math.Abs(pivot) < 1e-10) throw new InvalidOperationException("Ma trận không khả nghịch.");

                    for (int j = 0; j < 2 * n; j++) augmented[i, j] /= pivot;

                    for (int k = 0; k < n; k++)
                    {
                        if (k != i)
                        {
                            double factor = augmented[k, i];
                            for (int j = 0; j < 2 * n; j++) augmented[k, j] -= factor * augmented[i, j];
                        }
                    }
                }

                MATRIX inverse = new MATRIX(n, n);
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        inverse.matrix[i, j] = augmented[i, j + n];

                return inverse;
            }

            public static MATRIX operator *(MATRIX A, MATRIX B)
            {
                if (A.C != B.R)
                    throw new InvalidOperationException("Kích thước không hợp lệ để nhân ma trận.");

                MATRIX result = new MATRIX(A.R, B.C);
                for (int i = 0; i < A.R; i++)
                    for (int j = 0; j < B.C; j++)
                        for (int k = 0; k < A.C; k++)
                            result.matrix[i, j] += A.matrix[i, k] * B.matrix[k, j];
                return result;
            }

            public static MATRIX operator /(MATRIX A, MATRIX B)
            {
                if (B.R != B.C)
                    throw new InvalidOperationException("Chỉ có thể chia cho ma trận vuông.");

                return A * Inverse(B);
            }

            public void display()
            {
                for (int i = 0; i < this.R; i++)
                {
                    for (int j = 0; j < this.C; j++)
                        Console.Write($"{this.matrix[i, j]:0.00} ");
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
        }
    }
}
