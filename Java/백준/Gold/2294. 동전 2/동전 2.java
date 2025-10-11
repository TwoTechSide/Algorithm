import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static Integer[] arr;
    public static int[] dp;

    public static int func(int n) {

        if (dp[n] > 0)
            return dp[n];

        int cnt = 10_001;

        for (int coin: arr)
            if (n - coin > 0)
                cnt = Math.min(cnt, func(n-coin)+1);

        return dp[n] = cnt;
    }

    public static void main(String[] args) throws IOException {

        int n = read(), k = read();

        arr = new Integer[n];
        dp = new int[k+1];

        for (int i = 0; i < n; i++) {
            int num = read();

            arr[i] = num;
            if (num <= k)
                dp[num] = 1;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        func(k);

        System.out.println(dp[k] <= k ? dp[k] : -1);
    }

    public static int read() throws IOException {
        int N = 0, c;
        while((c = System.in.read()) != '\n' && c != ' ')
            N = N * 10 + c - '0';
        return N;
    }
}