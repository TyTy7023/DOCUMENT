import java.util.Scanner;

public class VacantLot extends Property{
	Scanner input = new Scanner(System.in);
	//Constructor 
	public VacantLot(){};
	public VacantLot(VacantLot vacantLot){
		super(vacantLot.id, vacantLot.length, vacantLot.width);
	}
	public VacantLot(String id, int length, int width){	
		super(id,length,width);
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
	//method
	public int salePrice(){
		return (length*width*10)*1000;
	} 
	public void print(){
		System.out.println("------VACANT LOT INFORMATION------");
		System.out.println("ID: "+getId());
		System.out.println("Length: "+getLength());
		System.out.println("Width: "+getWidth());
		System.out.println("Sale Price: "+salePrice());
	}
	public void enterInfo(){
		System.out.print("Enter ID: "); id=input.nextLine();
		System.out.print("Enter Length: "); length=input.nextInt();
		System.out.print("Enter Width: "); width=input.nextInt();
	}
}