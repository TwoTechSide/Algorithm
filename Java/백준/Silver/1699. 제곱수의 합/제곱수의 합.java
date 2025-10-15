import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {

            if (i <= Math.sqrt(N))
                dp[i * i] = 1;

            for (int j = 1; j*j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j*j] + dp[i-j*j]);
            }
        }

        System.out.println(dp[N]);
    }
}