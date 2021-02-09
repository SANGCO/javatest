package test;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class ChunWon {

    public static void main(String[] args) {
        String solve = solve(new BigInteger("100"));
        System.out.println(solve);
    }

    private static String solve3(BigInteger numb) {
        Format formatter = new DecimalFormat("###,###");
        //        NumberFormat.getInstance(Locale.KOREA).format();
        return formatter.format(numb.intValue());
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
