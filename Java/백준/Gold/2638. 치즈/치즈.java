import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	public static final int[] dx = new int[] {1, 0, -1, 0};
	public static final int[] dy = new int[] {0, 1, 0, -1};

	public static int N, M;
	public static int[][] cheeseMap;
	public static int result = 0;

	public static void main(String[] args) throws IOException {

		N = readInt();
		M = readInt();
		cheeseMap = new int[N][M];

		int cheese = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cheeseMap[i][j] = readInt();

				if (cheeseMap[i][j] == 1)
					cheese++;
			}
		}

		// 처음 모눈종이의 바깥 영역 확인
		for (int i = 0; i < M-1; i++) {
			checkOutside(i, 0);
			checkOutside(M-1-i, N-1);
		}
		for (int i = 0; i < N-1; i++) {
			checkOutside(M-1, i);
			checkOutside(0, N-1-i);
		}

		// 남아있는 치즈가 있는 동안 진행
		while (cheese > 0) {

			result++;
			List<int[]> meltCheeseList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					List<int[]> list = checkMeltCheese(j, i);

					if (list != null)
						meltCheeseList.addAll(list);
				}
			}

			cheese -= meltCheeseList.size();

			for (int[] pos: meltCheeseList) {
				cheeseMap[pos[0]][pos[1]] = 0;
				checkOutside(pos[1], pos[0]);
			}
		}

		System.out.println(result);
	}

	public static void checkOutside(int x, int y) {

		if (cheeseMap[y][x] != 0)
			return;

		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			if (cheeseMap[cy][cx] != 0)
				continue;

			cheeseMap[cy][cx] = -1;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				queue.offer(new int[] {nx, ny});
			}
		}
	}

	public static List<int[]> checkMeltCheese(int x, int y) throws IOException {

		if (cheeseMap[y][x] != result)
			return null;

		List<int[]> list = new ArrayList<>();
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			// 치즈가 있던 위치에 현재 시간으로 visited 역할 수행
			if (cheeseMap[cy][cx] == result+1)
				continue;

			cheeseMap[cy][cx] = result+1;
			int outsideCnt = 0;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (cheeseMap[ny][nx] == -1) {
					outsideCnt++;
					continue;
				}

				if (cheeseMap[ny][nx] == result)
					queue.offer(new int[] {nx, ny});
			}

			if (outsideCnt >= 2)
				list.add(new int[] {cy, cx});
		}

		return list;
	}

	public static int readInt() throws IOException {

		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}