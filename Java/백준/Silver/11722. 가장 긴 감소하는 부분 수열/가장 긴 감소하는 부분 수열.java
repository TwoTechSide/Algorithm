import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();

        int[] arr = new int[N];
        int[] dp = new int[N];

        int result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = read();

            int maxCnt = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    maxCnt = Math.max(maxCnt, dp[j]);
                }
            }

            result = Math.max(result, dp[i] = maxCnt + 1);
        }

        System.out.println(result);
    }

    public static int read() throws IOException {
        int N = 0, c;
        while((c = System.in.read()) != '\n' && c != ' ')
            N = N * 10 + c - '0';
        return N;
    }
}