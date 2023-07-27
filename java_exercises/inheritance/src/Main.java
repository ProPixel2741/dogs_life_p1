import com.qa.Circle;
import com.qa.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle("r1", "yellow", 0, 0, 10, 10);
        Rectangle r2 = new Rectangle("r2", "green", 2, 2, 5, 2);
        System.out.println(r1 + ", center point is :" + r1.getCenterPoint() + ", Area is :" + r1.getArea() + ". Is it a square: " + r1.isSquare());
        System.out.println(r2 + ", center point is :" + r2.getCenterPoint() + ", Area is :" + r2.getArea() + ". Is it a square: " + r2.isSquare());

        Circle c1 = new Circle("c1", "yellow", 0,0,10);
        Circle c2 = new Circle("c2", "green", 10,10,5);

        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Circle location: " + c1.getCurrentLocation());
        c1.move(10.5, 4.3);
        System.out.println("Circle new location " + c1.getCurrentLocation());
    }
}