
  public class Fraction implements Comparable<Fraction>{
    private int numerator;   
    private int denominator; 

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        shorten(); 
    }

    public Fraction() {
        this(1, 1); 
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public void add(Fraction other) {
        this.numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
    }
    
    public Fraction add(Fraction other1, Fraction other2) {  
        
        int num = other1.numerator * other2.denominator + other2.numerator * other1.denominator;
        int denom = other1.denominator * other2.denominator;
        return new Fraction(num, denom);
    }

    public Fraction sub(Fraction other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int denom = this.denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction mul(Fraction other) {
        int num = this.numerator * other.numerator;
        int denom = this.denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by a fraction with a zero numerator.");
        }
        int num = this.numerator * other.denominator;
        int denom = this.denominator * other.numerator;
        return new Fraction(num, denom);
    }

    private void shorten() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) { 
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public int compareTo(Fraction f) {
        int frac_1 = this.numerator * f.denominator;
        int frac_2 = this.denominator * f.numerator;
        if (frac_1 == frac_2)
            return 0;
        else if (frac_1 > frac_2)
            return 1;
        else
            return -1;
    }
}
