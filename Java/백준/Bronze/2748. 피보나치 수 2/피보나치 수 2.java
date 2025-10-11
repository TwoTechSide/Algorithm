import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();

        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++)
            dp[i] = dp[i-2] + dp[i-1];

        System.out.println(dp[N]);
    }

    public static int read() throws IOException {
        int N = 0, c;

        while((c = System.in.read()) != '\n')
            N = N*10+c-'0';

        return N;
    }
}