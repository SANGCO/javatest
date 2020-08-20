package effectiveJava;

public class MinimizeTheScopeOfLocalVariables {

    public static void main(String[] args) {
        for (int i = 0, n = test(); i < n; i++) {
            System.out.println("test 1");
        }

        for (int i = 0; i < test(); i++) {
            System.out.println("test 1");
        }
    }

    private static int test() {
        return 3;
    }

}
