package test;

import java.util.Random;

public class MathRandom {

    public static void main(String[] args) {
        System.out.println(Math.random());

        Random random = new Random();
        System.out.println(Math.abs(random.nextLong()));

        random.setSeed(System.currentTimeMillis());
        System.out.println(Math.abs(random.nextLong()));

        int test = 10000;

        for (int i = 0; i < 5; i++) {
            System.out.println("전" + test);
            int test2 = random.nextInt(test + 1);
            System.out.println("난수" + test2);
            test = test - test2;
            System.out.println("후" + test);
        }
    }

}
