public class Furniture{
    public string Name { get; set; }
    public string Material { get; set; }
    public string Color { get; set; }
    public int Price { get; set; }
    
    public Furniture(string name, string material, string color, int price){
        Name = name;
        Material = material;
        Color = color;
        Price = price;
    }
    public Furniture(){
        Name = "Unknown";
        Material = "Unknown";
        Color = "Unknown";
        Price = 0;
    }

    public void ShowInfo(){
        Console.WriteLine("Name: " + Name);
        Console.WriteLine("Material: " + Material);
        Console.WriteLine("Color: " + Color);
        Console.WriteLine("Price: " + Price);
    }
}