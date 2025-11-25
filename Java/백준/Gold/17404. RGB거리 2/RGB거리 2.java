import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		int N = readInt();

		int[][][] dp = new int[3][N][3];
		Arrays.fill(dp[0][0], 1_000);
		Arrays.fill(dp[1][0], 1_000);
		Arrays.fill(dp[2][0], 1_000);
		dp[0][0][0] = readInt();
		dp[1][0][1] = readInt();
		dp[2][0][2] = readInt();

		for (int i = 1; i < N; i++) {
			int n1 = readInt();
			int n2 = readInt();
			int n3 = readInt();
			// j -> [j]에서 시작한 dp를 기준으로 시작
			for (int j = 0; j < 3; j++) {
				dp[j][i][0] = Math.min(dp[j][i-1][1], dp[j][i-1][2]) + n1;
				dp[j][i][1] = Math.min(dp[j][i-1][0], dp[j][i-1][2]) + n2;
				dp[j][i][2] = Math.min(dp[j][i-1][0], dp[j][i-1][1]) + n3;
			}
		}

		int result1 = Math.min(dp[0][N-1][1], dp[0][N-1][2]);
		int result2 = Math.min(dp[1][N-1][0], dp[1][N-1][2]);
		int result3 = Math.min(dp[2][N-1][0], dp[2][N-1][1]);

		System.out.println(Math.min(Math.min(result1, result2),  result3));
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}