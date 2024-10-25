import java.util.Scanner;

public class House extends Property{
	private int floors;
    Scanner input = new Scanner(System.in);
	//Constructor
	public House(){}
	public House(House house){
		super(house.id,house.length,house.width);
		this.floors=house.floors;
	}
    public House(String id, int length, int width, int floors){
        super(id,length,width);
        this.floors=floors;
    }
    //setter
	public void setId(String id){
		this.id=id;
	}
	public void setLength(int length){
		this.length=length;
	}
	public void setWidth(int width){
		this.width=width;
	}
    public void setFloors(int floors) {
        this.floors = floors;
    }
	//getter
	public String getId(){
		return id;
	}
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}
    public int getFloors() {
        return floors;
    }
	//method
	public int salePrice(){
		return (length*width*10 + floors*100)*1000;
	} 
    public void print(){
        System.out.println("------HOUSE INFORMATION------");
        System.out.println("ID: "+getId());
        System.out.println("Length: "+getLength());
        System.out.println("Width: "+getWidth());
        System.out.println("Floors: "+getFloors());
        System.out.println("Sale Price: "+salePrice());
    }
    public void enterInfo(){
        System.out.print("Enter ID: "); id=input.nextLine();
        System.out.print("Enter Length: "); length=input.nextInt();
        System.out.print("Enter Width: "); width=input.nextInt();
        System.out.print("Enter Floors: "); floors=input.nextInt();
    }
}
