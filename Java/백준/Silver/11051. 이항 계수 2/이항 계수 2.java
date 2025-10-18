import java.io.IOException;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt(), K = readInt();
        int[][] dp = new int[N+1][N+1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            int j = 0;
            dp[i][j++] = 1;
            while (j < i) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10_007;
                j++;
            }
            dp[i][j] = 1;
        }

        System.out.println(dp[N][K]);
    }
}