public class SQUARE extends RECTANGLE {
    private double side;

    public SQUARE(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }
    public SQUARE(double side) {
        super("black", false, side, side);
    }

    public double getSide() {
        return this.side;
    }
    public void setSide(double side) {
        this.side = side;
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Square: " + super.toString() ;
    }
}