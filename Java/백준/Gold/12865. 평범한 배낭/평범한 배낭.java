import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // arr[0] : 무게
        // arr[1] : 가치
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // 문제 풀이 -> "0-1 Knapsack Problem" 알고리즘을 통해 풀어야 함
        // 집합 A에 대해
        //  - n번째 물건을 포함하지 않은 경우 : n-1개의 물건들 중 최적으로 고른 부분집합과 같음
        //  - n번째 물건을 포함하는 경우 : n-1개의 물건들 중 최적으로 고른 부분 집합에 물건 n을 더한 것과 같음

        // dp : [최대 개수+1][최대 무게+1]
        int[][] dp = new int[N+1][K+1];

        // i = 물건의 index, j = 배낭의 여유 무게
        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < K+1; w++) {

                // 만약 [i]번째 물건의 무게(=dp[i][j])가 배낭의 여유 무게 j보다 클 경우 -> 이전의 배열 값에서 가져옴
                if (W[i] > w) dp[i][w] = dp[i-1][w];

                // 만약 [i]번째 물건의 무게가 배낭의 여유 무게보다 작거나 같을 경우 -> 다음 2가지중 최댓값을 입력
                //     1. [i]번째 보석을 넣지 않은 경우
                //     2. [i-1]번째의 [w-W[i]]일 때의 최적의 값에서 [i]번째 보석을 넣은 경우
                else dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-W[i]] + V[i]);
            }
        }

        bw.write(dp[N][K] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}