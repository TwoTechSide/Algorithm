import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());  // 전깃줄 A
            list[i][1] = Integer.parseInt(st.nextToken());  // 전깃줄 B
        }

        // 문제 풀이
        // A의 값[배열_0]을 오름차순으로 정렬한 뒤, 최대한 겹치지 않은 이전의 값에서 누적합 진행
        Arrays.sort(list, (Comparator.comparingInt(o -> o[0])));
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++)
                // 이전의 전깃줄 중에서 최대한 겹치지 않는 경우에서 누적
                if (list[i][1] > list[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
        }

        // 가장 많이 겹치지 않는 경우의 수
        int maxNum = 0;
        for (int n : dp)
            maxNum = Math.max(maxNum, n);

        bw.write((N - maxNum) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}