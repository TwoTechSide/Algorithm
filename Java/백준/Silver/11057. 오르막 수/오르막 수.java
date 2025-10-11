import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();
        int[][] dp = new int[N+1][11];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 10; j++)
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10_007;
        }

        System.out.println(dp[N][10]);
    }

    public static int read() throws IOException {
        int N = 0, c;
        while((c = System.in.read()) != '\n' && c != ' ')
            N = N * 10 + c - '0';
        return N;
    }
}