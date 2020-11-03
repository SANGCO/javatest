package effectiveJava.multipleImplementations;

public interface A {

    void test1A();

    default void test2A() {
        System.out.println("test2A()");
    }

}
