import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();
        int[] dp = new int[N+1];

        long prevMax = 0;

        for (int i = 0; i < N; i++) {
            int day = read();
            int price = read();

            dp[i] = Math.toIntExact(Math.max(dp[i], prevMax));
            prevMax = Math.max(prevMax, dp[i]);

            if (i + day <= N)
                dp[i + day] = Math.max(dp[i + day], dp[i] + price);
        }

        System.out.println(Math.max(prevMax, dp[N]));
    }

    public static int read() throws IOException {
        int N = 0, c;

        while ((c = System.in.read()) != ' ' && c != '\n')
            N = N * 10 + c - '0';

        return N;
    }
}