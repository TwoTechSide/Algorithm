import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 값 입력
        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            S[i] = Integer.parseInt(st.nextToken());

        // 오름차순, 내림차순 DP 생성
        int[][] dp = new int[N][2];

        // 0부터 i 까지의 오름 수열 개수 확인
        for (int i=0; i<N; i++) {
            dp[i][0] = 1;

            for (int j=0; j<i; j++) {
                if (S[j] < S[i] && dp[i][0] < dp[j][0]+1)
                    dp[i][0] = dp[j][0]+1;
            }
        }

        // i부터 N-1 까지의 내림 수열 개수 확인
        // -> N-1부터 i 까지의 오름 수열 개수 확인
        for (int i=N-1; i>=0; i--) {
            dp[i][1] = 1;

            for (int j=N-1; j>i; j--) {
                if (S[j] < S[i] && dp[i][1] < dp[j][1]+1)
                    dp[i][1] = dp[j][1]+1;
            }
        }

        int result = 0;
        for (int[] list : dp) {
            int num = list[0] + list[1] - 1;
            result = Math.max(result, num);
        }

        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}