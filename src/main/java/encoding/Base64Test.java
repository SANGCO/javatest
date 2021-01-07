package encoding;

import java.util.Base64;

public class Base64Test {

    public static void main(String[] args) {
        String text = "가나다라";

        String encodedString1 = new String(Base64.getEncoder().encode(text.getBytes()));
        System.out.println(encodedString1);

        String encodedString2 = Base64.getEncoder().encodeToString(text.getBytes());;
        System.out.println(encodedString2);
    }

}
