using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTVN
{
    internal class Program
    {
// Lớp Vehicle
        public class Vehicle
        {
            public string Brand { get; set; }
            public string Model { get; set; }
            public int Year { get; set; }
            public int Speed { get; set; }

            public void DisplayInfo()
            {
                Console.WriteLine($"Brand: {Brand}, Model: {Model}, Year: {Year}, Speed: {Speed}");
            }
        }

        // Giao diện IDriveable
        public interface IDriveable
        {
            void Start();
            void Run();
            void Stop();
        }

        // Lớp Car kế thừa từ Vehicle và triển khai IDriveable
        public class Car : Vehicle, IDriveable
        {
            public int NumberOfDoors { get; set; }

            public void Start()
            {
                Console.WriteLine("Car is starting.");
            }

            public void Run()
            {
                Console.WriteLine("Car is running.");
            }

            public void Stop()
            {
                Console.WriteLine("Car has stopped.");
            }
        }

        // Lớp Motorcycle kế thừa từ Vehicle và triển khai IDriveable
        public class Motorcycle : Vehicle, IDriveable
        {
            public void Start()
            {
                Console.WriteLine("Motorcycle is starting.");
            }

            public void Run()
            {
                Console.WriteLine("Motorcycle is running.");
            }

            public void Stop()
            {
                Console.WriteLine("Motorcycle has stopped.");
            }
        }

        // Lớp VehicleManager để quản lý danh sách xe
        public class VehicleManager
        {
            private List<Vehicle> vehicles = new List<Vehicle>();

            public void AddVehicle(Vehicle vehicle)
            {
                vehicles.Add(vehicle);
            }

            public void DisplayAllVehicles()
            {
                foreach (var vehicle in vehicles)
                {
                    vehicle.DisplayInfo();
                }
            }
        }

        // Lớp Simulation mô phỏng hoạt động
        public class Simulation
        {
            public void RunSimulation(IDriveable driveable)
            {
                driveable.Start();
                driveable.Run();
                driveable.Stop();
            }
        }

        // Chương trình chính để kiểm tra
        static void Main()
        {
            Car car = new Car { Brand = "Toyota", Model = "Camry", Year = 2023, Speed = 120, NumberOfDoors = 4 };
            Motorcycle motorcycle = new Motorcycle { Brand = "Honda", Model = "CB500", Year = 2022, Speed = 180 };

            VehicleManager manager = new VehicleManager();
            manager.AddVehicle(car);
            manager.AddVehicle(motorcycle);

            Simulation simulation = new Simulation();
            simulation.RunSimulation(car);
            simulation.RunSimulation(motorcycle);

            manager.DisplayAllVehicles();
        }
        }

}

