using System;

namespace BT1_6
{
    // Enum for movement mode
    enum MOVEMODE { GROUND, AIR }

    // Abstract base class for Unit
    abstract class Unit
    {
        protected int HP;
        protected MOVEMODE moveMode;
        protected int groundDamage;
        protected int airDamage;

        // Constructor
        public Unit(int hp, MOVEMODE mode, int gDamage, int aDamage)
        {
            HP = hp;
            moveMode = mode;
            groundDamage = gDamage;
            airDamage = aDamage;
        }

        // Abstract methods for attack and damage
        public abstract void Attack(Unit enemy);
        public abstract void Damage(int pts);
    }

    // Terran class inheriting from Unit
    class Terran : Unit
    {
        // Constructor
        public Terran(int hp, MOVEMODE mode, int gDamage, int aDamage)
            : base(hp, mode, gDamage, aDamage) { }

        // Implementation of Attack
        public override void Attack(Unit enemy)
        {
            Console.WriteLine("Terran attacks!");
            // Implement attack logic
        }

        // Implementation of Damage
        public override void Damage(int pts)
        {
            HP -= pts;
            Console.WriteLine($"Terran takes {pts} damage, HP now: {HP}");
        }
    }

    // Protoss class inheriting from Unit
    class Protoss : Unit
    {
        private int PS; // Shield points

        // Constructor
        public Protoss(int hp, int shield, MOVEMODE mode, int gDamage, int aDamage)
            : base(hp, mode, gDamage, aDamage)
        {
            PS = shield;
        }

        // Implementation of Attack
        public override void Attack(Unit enemy)
        {
            Console.WriteLine("Protoss attacks!");
            // Implement attack logic
        }

        // Implementation of Damage
        public override void Damage(int pts)
        {
            if (PS > 0)
            {
                PS -= pts;
                if (PS < 0)
                {
                    HP += PS; // Apply remaining damage to HP if shield is depleted
                    PS = 0;
                }
            }
            else
            {
                HP -= pts;
            }

            Console.WriteLine($"Protoss takes {pts} damage, Shield: {PS}, HP: {HP}");
        }
    }

    // Main program
    internal class Program
    {
        static void Main(string[] args)
        {
            // Create Terran and Protoss units
            Terran terran = new Terran(100, MOVEMODE.GROUND, 20, 10);
            Protoss protoss = new Protoss(120, 50, MOVEMODE.AIR, 25, 15);

            // Example of attacks
            terran.Attack(protoss);
            protoss.Damage(30);

            protoss.Attack(terran);
            terran.Damage(25);

            Console.ReadLine(); // Keep the console window open
        }
    }
}
