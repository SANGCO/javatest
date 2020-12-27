package test;

public class RandomStr {

    public static void main(String[] args) {
        System.out.println(getRandomStr(3));
        System.out.println('O');
    }

    public static String getRandomStr(int size) {
        if (size > 0) {
            char[] temp = new char[size];
            for (int i = 0; i < temp.length; i++) {
                int a = (int) Math.floor(Math.random() * 2);

                // 숫자
                if (a == 0) {
                    temp[i] = (char)(Math.random() * 10 + 48);
                } else {
                // 알파벳
                    temp[i] = (char)(Math.random() * 26 + 65);
                }
            }
            return new String(temp);
        }
        return "";
    }

}
