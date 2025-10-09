import java.io.*;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {

        int n;
        Boolean bool = null;

        int a = 0, b = 0;

        while ((n = read()) == '0' || n == '1') {
            if (n == '0' && (bool == null || bool)) {
                bool = false;
                a++;
            } else if (n == '1' && (bool == null || !bool)) {
                bool = true;
                b++;
            }
        }

        System.out.println(Math.min(a, b));
    }

    public static int read() throws IOException {
        return System.in.read();
    }
}