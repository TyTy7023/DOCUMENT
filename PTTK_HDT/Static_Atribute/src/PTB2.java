public class PTB2 extends PTB1 {
    private double a;
    public PTB2(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    
    public double Delta(){
        return this.b*this.b-4*this.a*this.c;
    }

    public void getSolutions(){
        System.out.println("Solutions of "+this.toString());
        if(this.a==0)
            this.getSolutions();
        double delta = Delta();
        if(delta<0)
            System.out.println("No solution");
        else if(delta==0)
            System.out.println("x1 = x2 = " + -this.b/(2*this.a));
        else
            System.out.println("x1 = " + (-this.b+Math.sqrt(delta))/(2*this.a)
                + "\nx2 = " + (-this.b-Math.sqrt(delta))/(2*this.a));

        System.out.println();
    }

    public String toString(){
        return "PTB2: "+this.a+"x^2 + "+this.b+"x + "+this.c+" = 0";
    }    
}
