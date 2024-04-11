import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String text = "Hello, World!";
        System.out.println("Original Text : " + text);

        String md5Hash = calculateMD5(text);
        System.out.println("MD5 Hash : " + md5Hash);
    }

    public static String calculateMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

        // bytes to hex
        String md5Hash = new BigInteger(1, hashInBytes).toString(16);
        while (md5Hash.length() < 32) {
            md5Hash = "0" + md5Hash;
        }
        return md5Hash;
    }
}

/*
-----------------------------------------------------------
Output
----------------------------------------------------------
Original Text : Hello, World!
MD5 Hash : 65a8e27d8879283831b664bd8b7f0ad4
*/
