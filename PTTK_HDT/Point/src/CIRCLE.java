public class CIRCLE {
    private POINT center;
    private int r;

    public CIRCLE() {
        
    }

    public CIRCLE(POINT center, int r) {
        this.center = center;
        this.r = r;
    }

    public POINT getCenter() {
        return center;
    }

    public void setCenter(POINT center) {
        this.center = center;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public double Area() {
        return Math.PI * r*r;
    }

    @Override
    public String toString() {
        return "[" + center + ", " + r + "]";
    }
}
