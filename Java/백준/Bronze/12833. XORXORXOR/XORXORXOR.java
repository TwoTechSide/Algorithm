import java.io.IOException;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int A = readInt();
        int B = readInt();
        System.out.println((readInt() & 1) == 1 ? A ^ B : A);
    }
}