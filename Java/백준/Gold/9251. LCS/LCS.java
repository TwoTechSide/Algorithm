import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();

        // 문제 풀이
        // LCS (Longest Common Subsequence) 알고리즘 학습 필요

        int [][] dp = new int[c1.length+1][c2.length+1];

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {

                if (c1[i-1] != c2[j-1])
                    // (i, j) <- (i-1, j) 또는 (i, j-1)중 최댓값 대입
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                else
                    dp[i][j] = dp[i-1][j-1] + 1;
            }
        }

        // 마지막 가장 큰 합계가 저장된 dp 배열의 끝 값을 출력
        bw.write(dp[c1.length][c2.length] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}