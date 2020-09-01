package effectiveJava.multipleImplementations;

public abstract class B implements A {

    abstract void test1B();

    void test2B() {
        System.out.println("test2B()");
    }

}
