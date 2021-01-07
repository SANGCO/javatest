package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

class JWTTest {

    private static ECPublicKey EC_PUBLIC_KEY;
    private static ECPrivateKey EC_PRIVATE_KEY;

    /**
     * PEM 형식의 키를 Java의 ECPublicKey, ECPrivateKey로 변환
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    @BeforeAll
    public static void beforeAll() throws NoSuchAlgorithmException, InvalidKeySpecException {
        final KeyFactory keyPairGenerator = KeyFactory.getInstance("EC"); // EC is ECDSA in Java

        EC_PUBLIC_KEY = (ECPublicKey) keyPairGenerator.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE2R+XdTU5i09oZBE2iETk/9yQvV5Z+gulrw0s5B881Hg+UpD8Lu+uTK/Pgq4qJHmpvJXQJzOAXyFmU+7jOfZeKA==")));
        EC_PRIVATE_KEY = (ECPrivateKey) keyPairGenerator.generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64("MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCAB9uf5onio+9QBtd0eB57juyq1wkXZ/cv5H0b7aj2KZg==")));
    }

    /**
     * Java API를 이용해 JWT 생성
     *
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    @Test
    public void test_java_JWT() throws NoSuchAlgorithmException, IOException, InvalidKeyException, SignatureException {
        // Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, Object> header = new LinkedHashMap<>();
        header.put("kid", "sangco");
        header.put("typ", "JWT");
        header.put("alg", "ES256");
        final String headerStr =  Base64.encodeBase64URLSafeString(objectMapper.writeValueAsBytes(header));

        final Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("iss", "server");
        payload.put("iat", LocalDateTime.now().toString()); // JWT 생성 시간
        final String payloadStr = Base64.encodeBase64URLSafeString(objectMapper.writeValueAsBytes(payload));

        // When
        // Java 9부터 가능(Java 8에서 오류 발생 'java.security.NoSuchAlgorithmException: SHA256withECDSAinP1363Format Signature not available')
        // SHA256withECDSA와 서명 형식이 다름, 일부 라이브러리에서 검증이 실패하는 경우가 있었음
        final Signature signature = Signature.getInstance("SHA256withECDSAinP1363Format");
        signature.initSign(EC_PRIVATE_KEY);
        signature.update((headerStr + "." + payloadStr).getBytes());

        byte[] signatureBytes = signature.sign();

        final String signatureStr = Base64.encodeBase64URLSafeString(signatureBytes);

        final String jwt = headerStr + "." + payloadStr + "." + signatureStr;
        System.out.println(jwt);

        // Then
        verifyJWTByJava(jwt, EC_PUBLIC_KEY);
    }

    public void verifyJWTByJava(String jwt, ECPublicKey publicKey) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException {
        final String[] splitJwt = jwt.split("\\.");
        final String headerStr = splitJwt[0];
        final String payloadStr = splitJwt[1];
        final String signatureStr = splitJwt[2];

        final Signature signature = Signature.getInstance("SHA256withECDSAinP1363Format");
        signature.initVerify(publicKey);
        signature.update((headerStr + "." + payloadStr).getBytes());

        assert signature.verify(Base64.decodeBase64(signatureStr));
    }

    /**
     * Java API를 이용해 ES256 키 생성
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     */
    @Test
    public void test_pure_java_generateKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        // Given
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1")); // == P256

        // When
        final KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Then
        // Nothing Happen
        System.out.println("ecKey.publicKey: " +
                Base64.encodeBase64String(keyPair.getPublic().getEncoded()));
        System.out.println("ecKey.privateKey: " +
                Base64.encodeBase64String(keyPair.getPrivate().getEncoded()));
    }

}