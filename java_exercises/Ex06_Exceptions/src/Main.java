import com.qa.BadCalc;
import com.qa.MyConsoleReader;

public class Main {
    public static void main(String[] args) {
        BadCalc bc = new BadCalc();
        System.out.println("Mult result: " + bc.mult(2,3));
        try {
            System.out.println("Div result: " + bc.div(6, 0));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception");
        }

        MyConsoleReader m = new MyConsoleReader();
        m.readInputPrint();

    }
}