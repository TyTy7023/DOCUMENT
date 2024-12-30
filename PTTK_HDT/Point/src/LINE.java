public class LINE {
    private POINT A;
    private POINT B;

    public LINE() {
    }

    public LINE(POINT A, POINT B) {
        this.A = A;
        this.B = B;
    }

    public POINT getA() {
        return A;
    }

    public void setA(POINT A) {
        this.A = A;
    }

    public POINT getB() {
        return B;
    }

    public void setB(POINT B) {
        this.B = B;
    }

    public double distance() {
        return A.distance(B);
    }

    public double xintercept() {
        return -A.getY() + (A.getY() - B.getY()) / (A.getX() - B.getX()) * A.getX();
    }

    public double yintercept() {
        return -A.getX() + (A.getX() - B.getX()) / (A.getY() - B.getY()) * A.getY();
    }

    @Override
    public String toString() {
        return "[" + A + ", " + B + "]";
    }
} 
