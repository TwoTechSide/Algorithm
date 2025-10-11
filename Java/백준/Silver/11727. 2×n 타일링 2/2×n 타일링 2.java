import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++)
            dp[i] = (2*dp[i-2] + dp[i-1]) % 10_007;

        System.out.println(dp[N]);
    }

    public static int read() throws IOException {
        int N = 0, c;

        while((c = System.in.read()) != '\n')
            N = N*10+c-'0';

        return N;
    }
}