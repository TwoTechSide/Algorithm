import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] preSum = new int[N+1][M+1];

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= M; j++) {
                boolean boardB = ((i + j) & 1) == 0;
                boolean charB = str.charAt(j-1) == 'B';

                // [그려야하는 위치]와 [그리려는 값]이 다를 경우에만 누적합
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + (boardB ^ charB ? 1 : 0);

                if (i >= K && j >= K) {
                    int cnt = preSum[i][j] - preSum[i-K][j] - preSum[i][j-K] + preSum[i-K][j-K];
                    result = Math.min(result, Math.min(cnt, K*K - cnt));
                }
            }
        }

        System.out.println(result);
    }
}