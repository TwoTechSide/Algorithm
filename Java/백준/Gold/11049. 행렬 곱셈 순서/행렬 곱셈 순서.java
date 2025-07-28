import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[][] matrix = new long[N][2];
        long[][] dp = new long[N][N];

        for (long[] row : dp)
            Arrays.fill(row, Long.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Long.parseLong(st.nextToken());
            matrix[i][1] = Long.parseLong(st.nextToken());
            dp[i][i] = 0;   // 중복 계산을 피하기 위해 0 대입
        }

        // dp[A][B], dp[C][D]에 대해 곱셈 연산수 : matrix[A][0] * matrix[B][1] * matrix[D][1]
        // dp[A][D] = dp[A][B] + dp[C][D] + 곱셈 연산수

        for (int cnt = 1; cnt < N; cnt++) {
            for (int s = 0; s < N-cnt; s++) {
                for (int i = s; i < s + cnt; i++) {
                    dp[s][s+cnt] = Math.min(dp[s][s+cnt], dp[s][i] + dp[i+1][s+cnt] + matrix[s][0] * matrix[i][1] * matrix[s+cnt][1]);
                }
            }
        }

        bw.write(dp[0][N-1] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}