import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = read();

        int[] arr = new int[N];
        int[] dp = new int[N];

        int maxNum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = read();
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                // 이전의 오름차순 누적합 중 가장 큰 값에 덧셈
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                }
            }
            maxNum = Math.max(dp[i], maxNum);
        }

        System.out.println(maxNum);
    }

    public static int read() throws IOException {
        int N = 0, c;
        while((c = System.in.read()) != '\n' && c != ' ')
            N = N * 10 + c - '0';
        return N;
    }
}