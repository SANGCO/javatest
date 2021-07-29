package exception;

public class A {

    public static void main(String[] args) {
        test_A_2();
    }

    public static void test_A_1() {
//        throw new Exception();
        throw new RuntimeException();
    }

    public static void test_A_2() {
        test_A_1();
    }

}
