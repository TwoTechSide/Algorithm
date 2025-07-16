import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // dp[자릿수][0~9로 끝나는 경우의 수]
        int[][] dp = new int[101][10];
        dp[1] = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 2; i < N+1; i++) {
            for (int j=0; j<10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i-1][1];
                else if (j == 9)
                    dp[i][j] = dp[i-1][8];
                else
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];

                dp[i][j] %= 1_000_000_000;
            }
        }

        // (마지막 자릿수의 경우의 수 합계 % 1,000_000,000) 출력
        int answer = 0;
        for (int a : dp[N]) answer = (answer + a) % 1_000_000_000;

        bw.write(answer+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}