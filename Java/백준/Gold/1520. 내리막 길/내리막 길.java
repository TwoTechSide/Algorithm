import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	public static final int[][] nextDirection = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static int height;
	public static int width;

	public static int[][] graph;
	public static int[][] dp;

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException {
		height = readInt();
		width = readInt();

		graph = new int[height][width];
		dp = new int[height][width];

		for (int i = 0; i < height; i++) {
			Arrays.fill(dp[i], -1); // dp -> -1로 초기화

			for (int j = 0; j < width; j++)
				graph[i][j] = readInt();
		}

		// 해당 문제는 이전 경로를 저장해야 되기 때문에 stack이 아닌 재귀로 풀이
		System.out.println(dfs(0, 0));
    }

	public static int dfs(int x, int y) {
		if (x == width-1 && y == height-1) return 1;
		if (dp[y][x] != -1) return dp[y][x];

		dp[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + nextDirection[i][0];
			int ny = y + nextDirection[i][1];

			if (nx < 0 || nx >= width || ny < 0 || ny >= height || graph[y][x] <= graph[ny][nx])
				continue;

			dp[y][x] += dfs(nx, ny);
		}

		return dp[y][x];
	}
}
