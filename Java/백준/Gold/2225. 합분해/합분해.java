import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {

        int N = read(), K = read();

        int[][] dp = new int[K+1][N+1];

        // dp[1][?] -> 각 숫자의 조합이 1개 -> 해당 숫자 (0, 1, 2, 3, 4, 5, ...)
        Arrays.fill(dp[1], 1);

        for (int k = 2; k <= K; k++) {
            // dp[?][0] -> 0으로만 조합할 때 -> (0, 0+0, 0+0+0, 0+0+0+0, ...)
            dp[k][0] = 1;

            for(int n = 1; n <= N; n++) {
                // dp[k-1][n] : n 까지의 (k-1)개 조합에서 '+0'만 추가하는 경우
                // dp[k][n-1] : (n-1) 까지의 k개 조합에서 가장 뒤의 숫자에 1을 더하는 경우 (ex: 1+2+3 -> 1+2+4)
                dp[k][n] += (dp[k-1][n] + dp[k][n-1]) % 1_000_000_000;
            }
        }

        System.out.println(dp[K][N]);
    }

    public static int read() throws IOException {
        int N = 0, c;
        while((c = System.in.read()) != '\n' && c != ' ')
            N = N * 10 + c - '0';
        return N;
    }
}