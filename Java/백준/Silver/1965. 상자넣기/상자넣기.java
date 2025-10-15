import java.io.IOException;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int n = readInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = readInt();
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(result);
    }
}