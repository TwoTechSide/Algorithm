import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 숫자 입력
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        // Dynamic Programming을 위한 배열 추가 (Bottom-Up 방식)
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            dp[i] = 1;

            // 0번째부터 i번째 까지 수열 탐색
            for (int j=0; j<i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        // dp중 최댓값 출력
        bw.write(Arrays.stream(dp).max().getAsInt() + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}