import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int [N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, 0);

        int result = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (j + arr[j][0] <= i) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[j][1]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(result);
    }
}