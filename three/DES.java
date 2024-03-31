import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String key = "squirrel123"; // needs to be at least 8 characters for DES

        String plainText = "Hello, World!";
        System.out.println("Plain Text : " + plainText);

        String encryptedText = encrypt(key, plainText);
        System.out.println("Encrypted Text : " + encryptedText);

        String decryptedText = decrypt(key, encryptedText);
        System.out.println("Decrypted Text : " + decryptedText);
    }

    public static String encrypt(String key, String message) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(new DESKeySpec(key.getBytes()));

        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] textEncrypted = desCipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(textEncrypted);
    }

    public static String decrypt(String key, String message) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(message);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(new DESKeySpec(key.getBytes()));

        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] textDecrypted = desCipher.doFinal(bytes);

        return new String(textDecrypted);
    }
}


/*
---------------------------------------------------------------------------------------
Output
---------------------------------------------------------------------------------------
Plain Text : Hello, World!
Encrypted Text : EJgqB6Cf5lf79AND9a1CBw==
Decrypted Text : Hello, World!
*/
