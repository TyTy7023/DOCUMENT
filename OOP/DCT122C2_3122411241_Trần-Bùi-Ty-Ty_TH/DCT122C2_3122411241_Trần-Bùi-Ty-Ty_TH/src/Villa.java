import java.util.Scanner;

public class Villa extends Property implements Fees{
    Scanner input = new Scanner(System.in);
	//Constructor
	public Villa(){}
	public Villa(Villa villa){
		super(villa.id,villa.length,villa.width);
	}
    public Villa(String id, int length, int width){
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
		return (width*length*400)*1000;
	} 
	public int getFees(){
		return length*width*1000;
	}
	public int totalCost(){
		return getFees()+salePrice();	
	}
    public void print(){
        System.out.println("------VILLA INFORMATION------");
        System.out.println("ID: "+id);
        System.out.println("Length: "+ super.getLength());
        System.out.println("Width: "+getWidth());
        System.out.println("Sale Price: "+salePrice());
    }
    public void enterInfo(){
        System.out.print("Enter ID: "); id=input.nextLine();
        System.out.print("Enter Length: "); length=input.nextInt();
        System.out.print("Enter Width: "); width=input.nextInt();
    }
}
