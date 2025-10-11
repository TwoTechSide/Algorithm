import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][100_001];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[0][i] = Integer.parseInt(st1.nextToken());
                arr[1][i] = Integer.parseInt(st2.nextToken());
            }

            int[][] dp = new int[2][100_001];
            // 1, 2번째 줄 초기화
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            dp[0][2] = arr[0][2] + dp[1][1];
            dp[1][2] = arr[1][2] + dp[0][1];

            for (int i = 3; i <= N; i++) {
                int tmp = Math.max(dp[0][i-2], dp[1][i-2]);
                dp[0][i] = Math.max(dp[1][i-1], tmp) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], tmp) + arr[1][i];
            }

            bw.write(Math.max(Math.max(dp[0][N-1], dp[1][N-1]), Math.max(dp[0][N], dp[1][N])) + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}