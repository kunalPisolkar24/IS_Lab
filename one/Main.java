public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        StringBuilder andResult = new StringBuilder();
        StringBuilder orResult = new StringBuilder();
        StringBuilder xorResult = new StringBuilder();

        for (char ch : str.toCharArray()) {
            andResult.append((char) (ch & 127));
            orResult.append((char) (ch | 127));
            xorResult.append((char) (ch ^ 127));
        }

        System.out.println("AND with 127: " + andResult.toString());
        System.out.println("OR with 127: " + orResult.toString());
        System.out.println("XOR with 127: " + xorResult.toString());
    }
}

/*
----------------------------------------------------------
OUTPUT
----------------------------------------------------------

AND with 127: Hello World
OR with 127:
XOR with 127: 7▒_(

*/
