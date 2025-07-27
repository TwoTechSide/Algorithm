import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());

            int[][] dp = new int[K][K];     // dp[a][b]에 대해 파일 a~b의 비용의 합을 저장할 배열
            int[] sum = new int[K];         // 0부터 n 까지의 누적합을 저장할 배열

            // 34번째 줄의 Math.min에 사용할 dp[s][s+cnt]의 디폴트가 0인 경우 정상 작동 X
            for (int[] row : dp)
                Arrays.fill(row, Integer.MAX_VALUE);

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < K; n++) {
                int num = Integer.parseInt(st.nextToken());
                sum[n] = (n == 0) ? num : num + sum[n - 1];     // 누적합 저장
                dp[n][n] = 0;                                   // 파일이 1개일 때에는 중복 계산이 필요 없으므로 0 대입
            }

            for (int cnt = 1; cnt < K; cnt++) {         // 합칠 파일의 개수
                for (int s = 0; s < K-cnt; s++) {       // 합칠 파일의 시작 위치
                    for (int i = s; i < s+cnt; i++) {   // 두 묶음으로 나눌 분기점
                        dp[s][s+cnt] = Math.min(dp[s][s+cnt], dp[s][i] + dp[i+1][s+cnt] + sum[s+cnt] - (s == 0 ? 0 : sum[s-1]));
                        // sum[s+cnt] - sum[s-1] : 중복으로 더해지는 s부터 (s+cnt)까지의 비용 합
                        // 단, s == 0이면 sum[s-1]을 참조할 수 없으므로 삼항연산자 사용
                    }
                }
            }

            // 결론적으로 모든 파일의 합을 구하는 dp[0][K-1]을 출력하면 됨
            bw.write(dp[0][K-1]+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}