package test;

import java.util.Arrays;
import java.util.Random;

public class ASCII {

    static int[] asciiCode = new int[94];

    public static void main(String[] args) {
        for(int i = 33; i < 127; i++) {
            asciiCode[i - 33] = i;
        }

//        Arrays.stream(asciiCode).forEach(a -> System.out.println((char) a));
        System.out.println(excuteGenerate());
    }

    public static String excuteGenerate() {
        Random random = new Random(System.currentTimeMillis());
        int tablelength = asciiCode.length;
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < 3; i++) {
            buf.append((char) asciiCode[random.nextInt(tablelength)]);
        }

        return buf.toString();
    }

}
