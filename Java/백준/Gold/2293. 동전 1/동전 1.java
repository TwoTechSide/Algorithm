import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = read();
        int k = read();

        int[] arr = new int[n+1];
        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = read();
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j-arr[i]];
            }
        }

        System.out.println(dp[k]);
    }

    public static int read() throws IOException {
        int N = 0, c;
        while((c = System.in.read()) != '\n' && c != ' ')
            N = N * 10 + c - '0';
        return N;
    }
}