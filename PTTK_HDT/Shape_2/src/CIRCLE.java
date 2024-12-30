public class CIRCLE extends SHAPE{
    private double radius;

    public CIRCLE(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    public CIRCLE(double radius) {
        super("black", false); // Provide default values for color and filled
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    };
    public void setRadius(double radius){
        this.radius = radius;
    };

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    };

    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    };

    @Override
    public String toString() {
        return "Circle: " + super.toString() + ", radius=" + radius;
    }
}
