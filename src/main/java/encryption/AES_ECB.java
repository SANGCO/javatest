package encryption;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

public class AES_ECB {

    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        // Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // key를 생성하기 위해 SHA1를 사용한다
        byte[] hash = MessageDigest.getInstance("SHA1")
                .digest("myKey".getBytes(StandardCharsets.US_ASCII));
        System.out.println(Hex.encodeHexString(hash));

        // 128bit 키를 만들기위해 16바이트만큼 자른다
        byte[] keyBytes = Arrays.copyOf(hash, 16);
        System.out.println(Hex.encodeHexString(keyBytes));
        Key key = new SecretKeySpec(keyBytes, "AES");


        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] src = "0123456789abcdef".getBytes(StandardCharsets.US_ASCII);
        byte[] enc = cipher.doFinal(src);
        // 16진수 출력을 위해 org.apache.commons.codec.binary.Hex를 사용한다
        System.out.println(Hex.encodeHexString(enc));

        Cipher cipher1 = Cipher.getInstance("AES/ECB/NoPadding");
        cipher1.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = cipher1.doFinal(src);
        System.out.println(Hex.encodeHexString(enc));




//        SecretKeySpec key = new SecretKeySpec("abcd".getBytes(StandardCharsets.UTF_8), "AES");
//        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
//        cipher.init(Cipher.ENCRYPT_MODE, key);
//
//        byte[] src = "0123456789abcdef".getBytes(StandardCharsets.US_ASCII);
//        byte[] enc = cipher.doFinal(src);
//
//        System.out.println(Hex.encodeHexString(enc));




    }

}
