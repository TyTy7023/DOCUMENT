import java.util.Random;
public class ARRAY_SHAPE {
    SHAPE[] shapes;
    
    public ARRAY_SHAPE(SHAPE[] shapes){
        this.shapes = new SHAPE[shapes.length];
        for (int i = 0; i < shapes.length; i++){
            if(shapes[i] instanceof CIRCLE)
                this.shapes[i] = new CIRCLE(shapes[i].getColor(), shapes[i].isFilled(), ((CIRCLE)shapes[i]).getRadius());
            else if(shapes[i] instanceof RECTANGLE)
                this.shapes[i] = new RECTANGLE(shapes[i].getColor(), shapes[i].isFilled(), ((RECTANGLE)shapes[i]).getWidth(), ((RECTANGLE)shapes[i]).getLength());
            else if(shapes[i] instanceof SQUARE)
                this.shapes[i] = new SQUARE(shapes[i].getColor(), shapes[i].isFilled(), ((SQUARE)shapes[i]).getSide());
        }
    }
    public ARRAY_SHAPE(int size){
        this.shapes = new SHAPE[size];
        String[] color = {"red", "blue", "green", "yellow", "black", "white"};
        Random rand = new Random(156);
        for (int i = 0; i < size; i++){
            String colors = color[rand.nextInt(color.length)];
            boolean fill = rand.nextBoolean();
            int shape = rand.nextInt(3);
            if(shape == 0)
                this.shapes[i] = new CIRCLE(colors, fill, rand.nextDouble() * 100);
            else if(shape == 1)
                this.shapes[i] = new RECTANGLE(colors, fill, rand.nextDouble() * 100, rand.nextDouble() * 100);
            else if(shape == 2)
                this.shapes[i] = new SQUARE(colors, fill, rand.nextDouble() * 100);
        }
    }

    public double getArea(){
        double area = 0;
        for (SHAPE shape : shapes){
            area += shape.getArea(); // tính đa hình, lấy đúng công thức trên từng ngữ cảnh
        }
        return area;
    }

    public void print(){
        for (SHAPE shape : shapes){
            System.out.println(shape.toString());
        }
    }
}
