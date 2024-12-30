using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace BT2_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            Pet dog = new Pet("miki",6,"pull Pháp");
            Console.Write(dog.toString()); 

            Console.ReadKey();
        }
    }

    internal class Pet
    {
        private String name;
        private int age;
        private String type;

        public Pet(String name, int age, String type)
        {
            this.name = name;
            this.age = age;
            this.type = type;
        }
        public Pet() { }

        public String getName(){ return name; }
        public void setName(String name) { this.name = name; }

        public int getAge(){ return age; }
        public void setAge(int age){ this.age = age; }

        public String getType(){ return type; }
        public void setType(String type){ this.type = type;}

        public String toString()
        {
            return $"Pet[name: {name}, age: {age}, type: {type}]";
        }
    }
}
