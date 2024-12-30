using System;
using System.Data;
using System.Data.SqlClient;

namespace Example02
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            var connectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""C:\Users\Admin\OneDrive\Máy tính\C#\week11\BT1\BT1\hihi.mdf"";Integrated Security=True";

            using (var connection = new SqlConnection(connectionString))
            {

                var command = new SqlCommand("SELECT * FROM ORDER_ITEM WHERE ExtendedPrice BETWEEN 100 AND 200", connection);
                connection.Open();

                using (var dataReader = command.ExecuteReader(CommandBehavior.CloseConnection))
                {
                    if (dataReader.HasRows)
                    {
                        while (dataReader.Read())
                        {
                            var id = dataReader[0];
                            var q = dataReader[1];
                            var p = dataReader[2];
                            var e = dataReader[3];
                            var ex = dataReader[4];
                            Console.WriteLine($"[{id}] {q} {p} {e} {ex}");
                        }
                    }
                }
            }

            Console.ReadLine();
        }
    }
}
