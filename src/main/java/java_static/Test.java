package java_static;

public class Test {
    private final int instanceVariable;
    private static final int staticVariable = 1;

    public Test(int arg) {
        instanceVariable = arg;
    }

    public int getInstanceVariable() {
        return instanceVariable;
    }

    public static int getStaticVariable() {
        return staticVariable;
    }
}


