package effectiveJava.multipleImplementations;

public interface A {

    void test1A();

    static void test2A() {
        System.out.println("test2A()");
    }

}
