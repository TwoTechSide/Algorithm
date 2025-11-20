import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static int[][] sudoku = new int[9][9];
	public static List<int[]> emptyPoints = new ArrayList<>();
	public static boolean isPrinted = false;

	public static void backTracking(int depth) {

		if (isPrinted)
			return;

		if (depth == emptyPoints.size()) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}

			System.out.print(sb);
			isPrinted = true;

			return;
		}

		int[] cur = emptyPoints.get(depth);
		int y = cur[0];
		int x = cur[1];

		for (int j = 0; j < 9; j++) {
			if (isValid(j+1, x, y)) {
				sudoku[y][x] = j+1;
				backTracking(depth + 1);
				sudoku[y][x] = 0;
			}
		}
	}

	public static boolean isValid(int j, int x, int y) {
		int sx = (x / 3) * 3;
		int sy = (y / 3) * 3;

		for (int i = 0; i < 9; i++) {
			int cx = sx + i % 3;
			int cy = sy + i / 3;

			if (sudoku[y][i] == j || sudoku[i][x] == j || sudoku[cy][cx] == j)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = System.in.read() & 15;

				if (sudoku[i][j] == 0)
					emptyPoints.add(new int[] { i, j });
			}
			System.in.read();
		}

		backTracking(0);
	}
}