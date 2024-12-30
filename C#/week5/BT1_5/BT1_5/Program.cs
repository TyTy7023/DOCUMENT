using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BT1_5
{
    internal class Program
    {
        internal class Bird
        {
            private int _weight;
            public int Weight
            {
                get => _weight;
                set
                {
                    if (value > 0)
                        _weight = value;
                }
            }

            public void Feed() => _weight += 10;

            public Bird()
            {
                Console.WriteLine("Bird created");
            }

            public Bird(int weight)
            {
                _weight = weight;
                Console.WriteLine($"Bird created, {_weight} gr.");
            }

            public void Fly() => Console.WriteLine("Bird is flying");
        }

        internal class Parrot : Bird
        {
            public Parrot()
            {
                Console.WriteLine("Parrot created");
            }

            public Parrot(int weight) : base(weight)
            {
                // Calls base class (Bird) constructor with weight
            }

            public void Speak() => Console.WriteLine("Parrot is speaking");
        }

        internal class Cockatoo : Parrot
        {
            public Cockatoo()
            {
                Console.WriteLine("Cockatoo created");
            }

            public void Dance() => Console.WriteLine("Cockatoo is dancing");
        }

        internal class MainClass
        {
            private static void Main(string[] args)
            {
                Console.WriteLine("Bird:");
                Bird bird = new Bird(50) { Weight = 100 };  // Initial weight is set to 100
                bird.Feed();
                Console.WriteLine($"Weight: {bird.Weight}");
                bird.Fly();

                Console.WriteLine("\nParrot:");
                Parrot parrot = new Parrot(200);  // Parrot initialized with weight 200
                parrot.Feed();
                Console.WriteLine($"Weight: {parrot.Weight}");
                parrot.Fly();
                parrot.Speak();

                Console.WriteLine("\nCockatoo:");
                Cockatoo cockatoo = new Cockatoo() { Weight = 300 };  // Cockatoo initialized with weight 300
                cockatoo.Feed();
                Console.WriteLine($"Weight: {cockatoo.Weight}");
                cockatoo.Fly();
                cockatoo.Speak();
                cockatoo.Dance();

                Console.ReadKey();
            }
        }
    }
}
