import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][N+1];

        // [N+1][N+1] 크기의 표 -> 각 행마다 누적합 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = 0;

            // x1 ~ x2에 대해 (y2의 합) - (y-1의 합) 계산
            for (int j = x1; j <= x2; j++) {
                result += dp[j][y2];
                result -= dp[j][y1-1];
            }

            bw.write(result+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}