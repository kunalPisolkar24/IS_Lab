import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {
    private final static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        BigInteger p = BigInteger.probablePrime(512, random);
        BigInteger g = new BigInteger("3");
        BigInteger aliceSecret = new BigInteger("123456789");
        BigInteger bobSecret = new BigInteger("987654321");

        // Alice computes her public key
        BigInteger alicePublic = g.modPow(aliceSecret, p);

        // Bob computes his public key
        BigInteger bobPublic = g.modPow(bobSecret, p);

        // Alice and Bob exchange their public keys and compute their own private keys
        BigInteger alicePrivate = bobPublic.modPow(aliceSecret, p);
        BigInteger bobPrivate = alicePublic.modPow(bobSecret, p);

        System.out.println("Alice's Private Key: " + alicePrivate);
        System.out.println("Bob's Private Key: " + bobPrivate);
    }
}


/*
---------------------------------------------------------------------------
OUTPUT
---------------------------------------------------------------------------
Alice's Private Key: 1011323962726390962226829501383981736454147347824441820307222502646113578833089375551813238562433335379279765952750265836726665787363338122201749192443069
Bob's Private Key: 1011323962726390962226829501383981736454147347824441820307222502646113578833089375551813238562433335379279765952750265836726665787363338122201749192443069

*/
