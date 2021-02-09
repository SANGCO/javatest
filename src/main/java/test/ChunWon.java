package test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Stack;

public class ChunWon {

    public static void main(String[] args) {
        String solve = solve2(new BigInteger("10000000000000000000"));
        System.out.println(solve);
    }

    private static String solve2(BigInteger numb) {
        char[] chars = numb.toString().toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
            count++;
            if (count == 3) {
                sb.append(",");
                count = 0;
            }
        }

        return sb.reverse().toString();
    }

    private static String solve(BigInteger numb) {
        String s = numb.toString();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
            count++;
            if (count == 3) {
                sb.append(",");
                count = 0;
            }
        }

        return reverse(sb.toString());
    }

    private static String reverse(String numb) {
        char[] chars = numb.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
