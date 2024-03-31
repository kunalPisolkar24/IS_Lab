import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String key = "squirrel12345678"; // 16 characters for AES

        String plainText = "Hello, World!";
        System.out.println("Plain Text : " + plainText);

        String encryptedText = encrypt(key, plainText);
        System.out.println("Encrypted Text : " + encryptedText);

        String decryptedText = decrypt(key, encryptedText);
        System.out.println("Decrypted Text : " + decryptedText);
    }

    public static String encrypt(String key, String message) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] textEncrypted = aesCipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(textEncrypted);
    }

    public static String decrypt(String key, String message) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(message);

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] textDecrypted = aesCipher.doFinal(bytes);

        return new String(textDecrypted);
    }
}


/*
-----------------------------------------------------------------------------------
Output
-----------------------------------------------------------------------------------

Plain Text : Hello, World!
Encrypted Text : kceWOHB0jsjnOniZEvAyPg==
Decrypted Text : Hello, World!

*/
