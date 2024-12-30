using System;
using System.Text;

namespace BT3_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Pet pet = new Pet("Tủn",6,"Mèo");
            Car car = new Car(1999,"Japan",35);

            Console.WriteLine(pet.toString());
            pet.drive(car);

            Console.ReadKey();
        }
    }

    internal class Car
    {
        public int Year { get; set; }
        public String Make { get; set; }
        public int Speed { get; set; }

        public Car() {
            this.Make = "Toyota";
            this.Year = 2000;
            this.Speed = 0; 
        }
        public Car(int year, string make, int speed)
        {
            Year = year;
            Make = make;
            Speed = speed;
        }  

        public void Accelebrate(){ this.Speed += 5; }

        public void Brake() { this.Speed -= 5; }

        public String toString()
        {
            return $"Year: {Year}, Make: {Make}, Speed: {Speed}";
        }
    }
    internal class Pet
    {
        public String Name { get; set; }
        public int Age { get; set; }
        public String Type { get; set; }

        public Pet(String name, int age, String type)
        {
            this.Name = name;
            this.Age = age;
            this.Type = type;
        }
        public Pet() {
            this.Name = "Mướp";
            this.Age = 1;
            this.Type = "Mèo";
        }

        public String toString()
        {
            return $"Pet[name: {Name}, age: {Age}, type: {Type}]";
        }

        public void drive(Car car)
        {
            Console.WriteLine($"{Name} đi xe {car.toString()}");

            Console.WriteLine($"{Name} đi xe với tốc độ {car.Speed}");

            car.Accelebrate();
            Console.WriteLine($"{Name} tăng tốc thành {car.Speed}");

            car.Brake();
            Console.WriteLine($"{Name} giảm tốc còn {car.Speed}");
        }
    }



}
