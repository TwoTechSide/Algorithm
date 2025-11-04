import java.io.IOException;

public class Main {

    public static int readInt() throws IOException {
        int c = System.in.read();
        boolean negative = (c == '-');

        if (negative)
            c = System.in.read();

        int n = c & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return negative ? -n : n;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        boolean[] inserted = new boolean[2_000_001];
        int N = readInt();

        for (int i = 0; i < N; i++)
            inserted[readInt() + 1_000_000] = true;


        for (int i = 2_000_000; i >= 0; i--) {
            if (inserted[i])
                sb.append(i - 1_000_000).append("\n");
        }

        System.out.println(sb);
    }
}