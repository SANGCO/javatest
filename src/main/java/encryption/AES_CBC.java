package encryption;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

public class AES_CBC {

    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        // key를 생성하기 위해 SHA1를 사용한다.
        byte[] keyHash = MessageDigest.getInstance("SHA1")
                .digest("myKey".getBytes(StandardCharsets.US_ASCII));


        // 128bit 키를 만들기위해 16바이트만큼 자른다.
        byte[] keyBytes = Arrays.copyOf(keyHash, 16);
        Key key = new SecretKeySpec(keyBytes, "AES");


        byte[] ivHash = MessageDigest.getInstance("SHA1")
                .digest("myIv".getBytes(StandardCharsets.US_ASCII));
        byte[] ivBytes = Arrays.copyOf(ivHash, 16);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);


        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] src = "0123456789abcdef".getBytes(StandardCharsets.US_ASCII);
        byte[] enc = cipher.doFinal(src);
        System.out.println(Hex.encodeHexString(enc));
    }

}
