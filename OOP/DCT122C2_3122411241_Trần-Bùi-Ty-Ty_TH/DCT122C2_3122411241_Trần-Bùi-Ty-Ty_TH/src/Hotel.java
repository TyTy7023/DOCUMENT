import java.util.Scanner;
public class Hotel extends Property implements Fees{
	private int stars;
    Scanner input = new Scanner(System.in);
	//Constructor
	public Hotel(){}
	public Hotel(Hotel hotel){
		super(hotel.id,hotel.length,hotel.width);
		this.stars=hotel.stars;
	}
    public Hotel(String id, int length, int width, int stars){
        super(id,length,width);
        this.stars=stars;
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
    public void setStars(int stars){
		this.stars=stars;	
	}
	//getter
	// public String getId(){
	// 	return id;
	// }
	// public int getLength(){
	// 	return length;
	// }
	// public int getWidth(){
	// 	return width;
	// }
    public int getStars(){
		return stars;
	}
	//method
	public int salePrice(){
		return (100+stars*50)*1000;
	} 
	public int getFees(){
		return width*5000;
	}
	public int totalCost(){
		return getFees()+salePrice();	
	}
    public void print(){
        System.out.println("------HOTEL INFORMATION------");
        System.out.println("ID: "+ id);
        System.out.println("Length: "+ getLength());
        System.out.println("Width: "+super. getWidth());
        System.out.println("Stars: "+ getStars());
        System.out.println("Sale Price: "+salePrice());
    }
    public void enterInfo(){
        System.out.print("Enter ID: "); id=input.nextLine();
        System.out.print("Enter Length: "); length=input.nextInt();
        System.out.print("Enter Width: "); width=input.nextInt();
        System.out.print("Enter Stars: "); stars=input.nextInt();
    }
}