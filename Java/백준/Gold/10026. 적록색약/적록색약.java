import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static int[] dx = new int[] {1, 0, -1, 0};
	public static int[] dy = new int[] {0, 1, 0, -1};

	public static int N;
	public static char[][] image;
	public static int countB = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		image = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++)
				image[i][j] = str.charAt(j);
		}

		int result1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result1 += bfs1(i, j);
			}
		}

		int result2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result2 += bfs2(i, j);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result1).append(" ").append(countB + result2);

		System.out.println(sb);
	}

	public static int bfs1(int y, int x) {

		char color = image[y][x];

		// 이미 확인된 경로는 패스
		if (color == 'X' || color == 'O')
			return 0;

		// 색상이 파란색인 경우에만 'B' 카운트 증가
		if (color == 'B')
			countB++;

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{y, x});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			// 'B'인 경우에만 X 표시, 'R', 'G'인 경우 'O'로 표시
			if (image[cy][cx] == 'B') image[cy][cx] = 'X';
			else if (image[cy][cx] == 'R' || image[cy][cx] == 'G') image[cy][cx] = 'O';
			else continue;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (image[ny][nx] == color)
					queue.add(new int[] {ny, nx});
			}
		}
		return 1;
	}

	public static int bfs2(int y, int x) {

		// 'O'인 경우에만 확인
		if (image[y][x] != 'O')
			return 0;

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{y, x});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			if (image[cy][cx] != 'O')
				continue;

			image[cy][cx] = 'X';

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (image[ny][nx] != 'X')
					queue.add(new int[] {ny, nx});
			}
		}
		return 1;
	}
}