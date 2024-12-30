public class App {
    public static void main(String[] args) throws Exception {
        POINT p1 = new POINT(1, 2);
        System.out.println(p1);
        System.out.println("Khoang cach giua 2 diem: " + p1.distance(new POINT(3, 4)));

        LINE line = new LINE(p1, new POINT(3, 4));
        System.out.println(line);
        System.out.println("Khoang cach giua 2 diem tren duong thang: " + line.distance());

        CIRCLE circle = new CIRCLE(p1, 5);
        System.out.println(circle);
        System.out.println("Dien tich hinh tron: " + circle.Area());

        CYLINDER cylinder = new CYLINDER(p1, 5, 10);
        System.out.println(cylinder);
        System.out.println("Dien tich hinh tru: " + cylinder.Area());
        System.out.println("The tich hinh tru: " + cylinder.Volume());

    }
}
