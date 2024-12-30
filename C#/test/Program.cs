using System;

namespace BT1_4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("DAY: ");
            int day = int.Parse(Console.ReadLine());
            Console.WriteLine("MONTH: ");
            int month = int.Parse(Console.ReadLine());
            Console.WriteLine("YEAR: ");
            int year = int.Parse(Console.ReadLine());

            Day date = new Day(day, month, year);
            date.showCalendar();

            Console.ReadLine();
        }
    }

    public enum DAY
    {
        Sunday = 0,
        Monday = 1,
        Tuesday = 2,
        Wednesday = 3,
        Thursday = 4,
        Friday = 5,
        Saturday = 6
    }

    public class Day
    {
        public int year { get; set; }
        public int month { get; set; }
        public int day { get; set; }

        public Day(int day, int month, int year)
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        // Check if a year is a leap year
        public static bool isLeapYear(int year)
        {
            return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
        }

        // Get the number of days in a given month and year
        public static int DayInMonth(int month, int year)
        {
            if (month == 2)
            {
                return isLeapYear(year) ? 29 : 28;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11)
            {
                return 30;
            }
            return 31;
        }

        // Zeller's Congruence formula to calculate the day of the week
        public DAY dayInWeek()
        {
            int m = month < 3 ? month + 12 : month;  // Adjust month if it is Jan or Feb
            int y = month < 3 ? year - 1 : year;  // Adjust year if month is Jan or Feb

            int K = y % 100;  // Year of the century
            int J = y / 100; // Century

            // Zeller's Congruence formula
            int dayOfWeek = (day + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + 5 * J) % 7;

            // Map the result to Sunday = 0, Monday = 1, ..., Saturday = 6
            return (DAY)((dayOfWeek + 5) % 7);  // This maps Saturday (0) to 6, Sunday (1) to 0, etc.
        }

        // Find the first day of the month using Zeller's Congruence
        public DAY firstDayOfMonth()
        {
            int m = month < 3 ? month + 12 : month;  // Adjust month if it is Jan or Feb
            int y = month < 3 ? year - 1 : year;  // Adjust year if month is Jan or Feb

            int K = y % 100;  // Year of the century
            int J = y / 100; // Century

            // Zeller's Congruence formula to calculate the day of the week
            int dayOfWeek = (1 + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + 5 * J) % 7;

            // Adjust to match Sunday = 0, Monday = 1, ..., Saturday = 6
            return (DAY)((dayOfWeek + 5) % 7);  // This ensures Sunday = 0, Monday = 1, ..., Saturday = 6
        }

        // Show the calendar for a given month and year
        public void showCalendar()
        {
            int daysInMonth = DayInMonth(this.month, this.year);
            DAY firstDay = firstDayOfMonth();

            Console.WriteLine($"Calendar for {this.month}/{this.year}");

            Console.WriteLine("Sun Mon Tue Wed Thu Fri Sat");

            int startDay = (int)firstDay;

            // Print initial spaces to align with the first day
            for (int i = 0; i <= startDay; i++)
            {
                Console.Write("    ");
            }

            // Print the days of the month
            for (int day = 1; day <= daysInMonth; day++)
            {
                Console.Write($"{day,3} ");

                // Move to the next line after every Saturday (7th day)
                if ((startDay + day) % 7 == 0)
                {
                    Console.WriteLine();
                }
            }

            // Print a new line after finishing the calendar
            Console.WriteLine();
        }
    }
}
