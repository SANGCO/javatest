package effectiveJava;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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


        Map<String, String> map = new HashMap<>();
        map.put("1", "111");
        map.put("2", "222");
        map.put("3", "333");

        Set<String> strings1 = map.keySet();
        Set<String> strings2 = map.keySet();
        Set<String> strings3 = map.keySet();

        strings1.remove("1");

    }

}
