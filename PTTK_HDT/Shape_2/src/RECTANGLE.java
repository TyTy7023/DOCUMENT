public class RECTANGLE extends SHAPE {
    private double width;
    private double length;

    public RECTANGLE(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public RECTANGLE(double width, double length) {
        super("black", false); // Provide default values for color and filled
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public String toString() {
        return "Rectangle: " + super.toString() + ", width = " + width + ", length = " + length;
    }
    
}
