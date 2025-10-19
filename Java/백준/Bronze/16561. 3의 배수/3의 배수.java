import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt() / 3;

        int sum = 1;
        int cnt = 2;
        for (int i = 3; i < N; i++)
            sum += cnt++;

        System.out.println(sum);
    }
}