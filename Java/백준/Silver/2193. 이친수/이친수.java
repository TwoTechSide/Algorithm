import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[91];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int prev = 1; prev <= i-2; prev++) {
                dp[i] += dp[prev];
            }
            dp[i]++;
        }

        System.out.println(dp[N]);
    }
}