public class PTB1 implements PT {
    protected double c;
    protected double b;

    public PTB1(double c, double b) {
        this.c = c;
        this.b = b;
    }

    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }

    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    
    public void getSolutions(){
        System.out.println("Solutions of "+this.toString());
        if(c==0)
            if(b==0)
                System.out.println("Infinite solutions");
            else
                System.out.println("No solution");
        else
            System.out.println("x = "+-c/b);

        System.out.println();
    }
    public String toString(){
        return "PTB1: "+this.b+"x + "+this.c+" = 0";
    }
}
