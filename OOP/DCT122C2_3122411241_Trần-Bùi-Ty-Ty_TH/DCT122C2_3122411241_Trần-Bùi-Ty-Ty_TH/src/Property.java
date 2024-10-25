public abstract class Property{
	protected String id;
	protected int length, width;
	// Constructor
	public Property (){};
	public Property (String id, int length, int width){
		this.id = id;
		this.length = length;
		this.width = width;
	}
	//setter
	public abstract void setId(String id);
	public void setLength(int length){}
	public void setWidth(int width){}
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
	public int salePrice(){ return 0;}
	public void print(){}
	public void enterInfo(){}
	public int totalCost(){ return 0;};
	public int getFees(){ return 0;};
}