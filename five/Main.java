 import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String plainText = "Hello, World!";
        System.out.println("Plain Text : " + plainText);

        String encryptedText = encrypt(publicKey, plainText);
        System.out.println("Encrypted Text : " + encryptedText);

        String decryptedText = decrypt(privateKey, encryptedText);
        System.out.println("Decrypted Text : " + decryptedText);
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public static String encrypt(PublicKey key, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
    }

    public static String decrypt(PrivateKey key, String encrypted) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(encrypted);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(bytes), "UTF-8");
    }
}


/*
-----------------------------------------------------------
Output
----------------------------------------------------------
Plain Text : Hello, World!

Encrypted Text : kPsmmJQuHckF71TrRdVBLQT6cu9vQkNeV4UsLYQ2G99uUscNoRcbSEXmIcChBA10mpL3WhCzQh010MDyS+OiZVmaJR6lFNN5aN25JkVAv8n9AxoEFJsS1VL4472QhRSMlK2A+FPPtZW0Y1FToc96xyjRVLB78FgU5IyB7MqqC3AYrQlYQ+sQ409BkZDebVZQrs36hjJLa4u70o+d3tR8bE0StI2yqc2qoGO9KwjVIgjgAveE0YfAzASgOoj/K5uYgqmQkJs58ni7M0w2tfV17bmq8BcCaty6tv+6uw6GPnKyTG/zXnx+UC4hUYdKOkzNWLUzNCrXj9G3Oo4IJDCm6w==

Decrypted Text : Hello, World!

*/
