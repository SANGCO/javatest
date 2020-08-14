package java_static;

public class MainTest {
    public static void main(String[] args) {
        Test test = new Test(0);
        System.out.println(test.getInstanceVariable());
        System.out.println(Test.getStaticVariable());
    }
}
