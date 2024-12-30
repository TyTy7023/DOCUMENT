using System;
using System.Runtime.InteropServices;
using System.Text;

namespace BT5_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Pet pet = new Pet("Tủn", 6, "Mèo");
            Car car = new Car(1999, "Japan", 65);
            Employee employee = new Employee();

            employee.HandOut(car, pet);

            Console.ReadKey();
        }
    }

    internal class Car
    {
        public int Year { get; set; }
        public String Make { get; set; }
        public int Speed { get; set; }

        public Car()
        {
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

        public void Accelebrate() { this.Speed += 5; }

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
        public Pet()
        {
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

    internal class Employee
    {
        public String Name { get; set; }
        public int idNumber { get; set; }
        public String Department { get; set; }
        public String Position { get; set; }

        public Employee()
        {
            this.Name = "Ty";
            this.idNumber = 0;
            this.Position = "Boss";
            this.Department = "CNTT";
        }
        public Employee(string name, int idNumber, string department, string position)
        {
            Name = name;
            this.idNumber = idNumber;
            Department = department;
            Position = position;
        }
        public Employee(String name, int idNumber)
        {
            this.Name = name;
            this.idNumber = idNumber;
        }

        public String toString()
        {
            return $"Name: {Name}, idNumber: {idNumber}, Position: {Position}, Department: {Department} ";
        }

        public void HandOut(Car car, Pet pet) {
            Console.WriteLine(toString() );

            Console.WriteLine($"{Name} chở {pet.Name} đi chơi với tốc độ {car.Speed}");

            car.Accelebrate();
            Console.WriteLine($"{Name} chở {pet.Name} nhanh hơn với tốc độ {car.Speed}");

            car.Brake();
            Console.WriteLine($"{Name} chở {pet.Name} châm hơn với tốc độ {car.Speed}");
        }
    }

}
