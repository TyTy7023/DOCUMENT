public class LINE {
    POINT A, B;

    public LINE(POINT A, POINT B) {
        this.A = A;
        this.B = B;
    }
    public LINE() {
        this.A = new POINT();
        this.B = new POINT();
    }

    public void setA(POINT A) {
        this.A = A;
    }
    public void setB(POINT B) {
        this.B = B;
    }

    public POINT getA() {
        return this.A;
    }
    public POINT getB() {
        return this.B;
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.A.getX() - this.B.getX(), 2) + Math.pow(this.A.getY() - this.B.getY(), 2));
    }
    public double xIntercept() {
        return this.A.getX() - (this.A.getY() * (this.B.getX() - this.A.getX()) / (this.B.getY() - this.A.getY()));
    } 
    public double yIntercept() {
        return this.A.getY() - (this.A.getX() * (this.B.getY() - this.A.getY()) / (this.B.getX() - this.A.getX()));
    }

    @Override
    public String toString() {
        return "[" + this.A + ", " + this.B + "]";
    }
}
