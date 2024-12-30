import java.util.Random;
public class Array_PT {
    PT pts[];

    public Array_PT(int size) {
        pts = new PT[size];
        Random rand = new Random(1712);
        for (int i = 0; i < size; i++) {
            if (rand.nextBoolean())
                pts[i] = new PTB1(rand.nextDouble() * 20, rand.nextDouble() * 20);
            else 
                pts[i] = new PTB2(rand.nextDouble() * 20, rand.nextDouble() * 20, rand.nextDouble() * 20);
        }
    }

    public void getSolutions() {
        for (PT pt : pts) {
            pt.getSolutions();
        }
    }
}
