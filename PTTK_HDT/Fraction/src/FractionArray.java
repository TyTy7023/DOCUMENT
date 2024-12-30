import java.util.ArrayList;
import java.util.Random;

public class FractionArray{
    private ArrayList<Fraction> fractions = new ArrayList<Fraction>();
    private int num; 

    public FractionArray(int num) {
        this.num = num;
        createArray(this.num);
    }
    public FractionArray(ArrayList<Fraction> fractions) {
        this.fractions = fractions;
    }

    public void createArray(int num){
        
        for (int i = 0; i < num; i++) 
        {
            Random rand = new Random();
            Fraction f = new Fraction(rand.nextInt(10), rand.nextInt(10) + 1);
            this.fractions.add(f);
        }
    }
    
    public void addFrac(int pos, Fraction f){
        this.fractions.add(pos, f);
    }

    public void addFrac(Fraction f){
        this.fractions.add(f);
    }

    public int removeFrac(int pos){
        if (pos < 0 || pos >= this.num)
            return 0;
        this.fractions.remove(pos);
        return 1;
    }

    public int removeFrac(Fraction f){
        for (int i = 0; i < this.num; i++) 
            if (this.fractions.get(i).compareTo(f) == 0)
            {
                this.fractions.remove(i);
                return 1;
            }
        return 0;
    }

    private void sort(){
        for (int i = 0; i < this.num - 1; i++) 
            for (int j = i + 1; j < this.num; j++) 
                if (fractions.get(i).compareTo(fractions.get(j)) > 0)
                {
                    Fraction temp = this.fractions.get(i);
                    this.fractions.set(i, this.fractions.get(j));
                    this.fractions.set(j, temp);
                }
    }

    public int findFraction(Fraction f){
        for (int i = 0; i < this.num; i++) 
            if (this.fractions.get(i).compareTo(f) == 0)
                return 1;
        return 0;
    }

    public Fraction findMax(){
        sort();
        return this.fractions.get(this.num - 1);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.fractions.size(); i++) 
            s += this.fractions.get(i) + "\t";
        return s+= "\n";
    }
}
