import java.io.IOException;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt(), M = readInt();
        int[][] dp = new int[N+1][M+1];

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                dp[y][x] = Math.max(dp[y][x-1], dp[y-1][x]) + readInt();
            }
        }

        System.out.println(dp[N][M]);
    }
}