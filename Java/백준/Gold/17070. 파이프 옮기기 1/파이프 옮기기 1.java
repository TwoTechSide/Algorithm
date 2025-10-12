import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] wall; // 벽이 있는 경우 -> true
    public static int[][][] dp;     // dp[?][h][w] -> 오른쪽, 대각선, 아래 / 누적합으로 진행

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        wall = new boolean[N+1][N+1];
        dp = new int[3][N+1][N+1];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                wall[y][x] = st.nextToken().equals("1");
            }
        }

        // 파이프의 끝 방향 기준
        dp[0][0][1] = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 1; x < N; x++) {
                move(x, y);
            }
        }

        System.out.println(dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1]);
    }

    public static void move(int x, int y) {

        // 오른쪽 방향
        if (!wall[y][x+1])
            dp[0][y][x+1] += dp[0][y][x] + dp[1][y][x];

        // 대각선 방향
        if (!wall[y][x+1] && !wall[y+1][x+1] && !wall[y+1][x])
            dp[1][y+1][x+1] += dp[0][y][x] + dp[1][y][x] + dp[2][y][x];

        // 아래 방향
        if (!wall[y+1][x])
            dp[2][y+1][x] += dp[1][y][x] + dp[2][y][x];
    }
}