import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        // dp[N] -> dp[N-1]에서 가로 1개 추가 + dp[N-2]에서 가로 2개 추가

        for (int i = 3; i <= N; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 10_007;

        System.out.println(dp[N]);
    }

    public static int read() throws IOException {
        int N = 0, c;

        while((c = System.in.read()) != '\n')
            N = N*10+c-'0';

        return N;
    }
}