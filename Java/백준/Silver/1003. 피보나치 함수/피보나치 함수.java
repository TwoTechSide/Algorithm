import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 피보나치 함수를 실행했을 때 f(0)과 (1)이 호출되는 횟수를 dp에 저장
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            bw.write(dp[num][0] + " ");
            bw.write(dp[num][1] + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}