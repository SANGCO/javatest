package encoding;

import java.io.UnsupportedEncodingException;

public class EncodingTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        test1();
        test2();
        test3();
        test4();
        test5();
        // 현재 에디터는 UTF-8
        // Unicode Transformation Format
        test6();
        byteTest();
    }

    private static void byteTest() throws UnsupportedEncodingException {
        String korean = "ㄱ";
        String english = "a";

        // 1바이트
        byte byteA = 'a';
        // ㄱ은 byte 변수에 못 담겠지?
//        byte byteㄱ = 'ㄱ';
        // 2바이트
        char charA = 'a';
        char charA2 = 65;
        char charA3 = 0x0041;

        int test1 = korean.getBytes("UTF-8").length;
        System.out.println("한글 UTF-8 " + test1);
        int test2 = korean.getBytes("ASCII").length;
        System.out.println("한글 ASCII " + test2);

        int test3 = english.getBytes("UTF-8").length;
        System.out.println("영어 UTF-8 " + test3);
        int test4 = english.getBytes("ASCII").length;
        System.out.println("영어 ASCII " + test4);

    }

    private static void test1() {
        System.out.println("=========================================");
        String korean = "한글";
        byte[] bytes = korean.getBytes();
        String string = new String(bytes);
        System.out.println(string);
        System.out.println("=========================================");
    }

    private static void test2() throws UnsupportedEncodingException {
        System.out.println("=========================================");
        String korean = "한글";
        byte[] bytes = korean.getBytes("UTF-16");
        String string = new String(bytes);
        System.out.println(string);
        System.out.println("=========================================");
    }

    private static void test3() throws UnsupportedEncodingException {
        System.out.println("=========================================");
        String korean = "한글";
        byte[] bytes = korean.getBytes("UTF-16");
        String string = new String(bytes, "UTF-16");
        System.out.println(string);
        System.out.println("=========================================");
    }

    private static void test4() throws UnsupportedEncodingException {
        System.out.println("=========================================");
        String korean = "한글";
        byte[] bytes = korean.getBytes("EUC-KR");
        String string = new String(bytes, "EUC-KR");
        System.out.println(string);
        System.out.println("=========================================");
    }

    private static void test5() throws UnsupportedEncodingException {
        System.out.println("=========================================");
        String korean = "한글";
        byte[] bytes = korean.getBytes("EUC-KR");
        String string = new String(bytes);
        System.out.println(string);
        System.out.println("=========================================");
    }

    private static void test6() throws UnsupportedEncodingException {
        System.out.println("=========================================");
        String korean = "한글";
        byte[] bytes = korean.getBytes("UTF-8");
        String string = new String(bytes);
        System.out.println(string);
        System.out.println("=========================================");
    }

}
