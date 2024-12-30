public class Plant{
    public string type { get; set; }
    private string leafColor;
    public string LeafColor { 
        get => leafColor; 
        set => leafColor = value; 
    }
   
    public Plant(string type, string leafColor){
        this.type = type;
        this.leafColor = leafColor;
    }
     
    public Plant(){
        type = "Unknown";
        leafColor = "Unknown";
    }

    public void ShowInfo(){
        Console.WriteLine("Type: " + type);
        Console.WriteLine("Leaf color: " + leafColor);
    }


}