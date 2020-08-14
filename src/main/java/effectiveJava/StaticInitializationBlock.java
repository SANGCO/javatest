package effectiveJava;

import java.math.BigInteger;

public class StaticInitializationBlock {

    private static String a;
    static String b;

    static {
        a = "상코";
        b = "SANGCO";
    }

    public static BigInteger valueOf(String val) {
        return new BigInteger(val);
    }

    public static void main(String[] args) {
        valueOf("15");
        System.out.println(a);
        System.out.println(b);

        BigInteger bi = BigInteger.valueOf(0);
        System.out.println(bi);
    }

}
