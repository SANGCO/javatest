package encryption;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class AES_ECBTest {

    @Test
    public void whenIsEncryptedAndDecrypted_thenDecryptedEqualsOriginal()
            throws Exception {

        String encryptionKeyString =  "thisisa128bitkey";
        String originalMessage = "This is a secret message";
        byte[] encryptionKeyBytes = encryptionKeyString.getBytes();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedMessageBytes = cipher.doFinal(originalMessage.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedMessageBytes = cipher.doFinal(encryptedMessageBytes);
        assertEquals(originalMessage, new String(decryptedMessageBytes));

        BigInteger bigInteger = new BigInteger(decryptedMessageBytes);
        System.out.println(bigInteger.intValue());
    }

}