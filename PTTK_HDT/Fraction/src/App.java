public class App {
    public static void main(String[] args) throws Exception {
        FractionArray fa = new FractionArray(5);
        System.out.println("Array: ");
        System.out.println(fa.toString());

        Fraction f = new Fraction(1, 2);
        fa.addFrac(2, f);
        System.out.println("Array after adding a fraction: ");
        System.out.println(fa.toString());
  
        int valid = fa.removeFrac(2);
        if (valid == 1)
            System.out.println("Array after removing a fraction: ");
        else 
            System.out.println("Removing is fail: ");
        System.out.println(fa.toString());

        if (fa.findFraction(f) == 1)
            System.out.println("Fraction found in array\n");
        else 
            System.out.println("Fraction not found in array\n");

        System.out.println("Array after sort: ");
        Fraction max = fa.findMax();
        System.out.println(fa.toString());
        System.out.println("Max fraction: " + max);


    }
}
