public class CYLINDER extends CIRCLE {
    private int height;

    public CYLINDER() {
    }

    public CYLINDER(POINT p, int r, int height) {
        super(p,r);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double Area() {
        return 2 * super.Area() + 2 * Math.PI * getR() * height;
    }

    public double Volume() {
        return super.Area() * height;
    }

    @Override
    public String toString() {
        return "[" + getCenter() + ", " + getR() + ", " + height + "]";
    }

}
