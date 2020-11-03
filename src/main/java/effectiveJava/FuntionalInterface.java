package effectiveJava;

import java.util.function.UnaryOperator;

public class FuntionalInterface {

    public static void main(String[] args) {
        FuntionalInterface f = new FuntionalInterface();
        f.test(String::toLowerCase);
    }

    public void test(UnaryOperator<String> u) {
        System.out.println(u.apply("SANGCO"));
        "SANGCO".toLowerCase();

        UnaryOperator.identity();
    }

}
