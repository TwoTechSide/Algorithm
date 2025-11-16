import java.io.IOException;

public class Main {

	public static int N;
	public static boolean[][] paper;
	public static int white = 0;
	public static int blue = 0;

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException {
		N = readInt();
		paper = new boolean[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				paper[i][j] = readInt() == 1;

		int last = recursion(0, 0, N);

		if (last == 1) blue++;
		else if (last == -1) white++;

		System.out.println(white + "\n" + blue);
    }

	public static int recursion(int x, int y, int size) {

		if (size == 1)
			return paper[x][y] ? 1 : -1;

		size /= 2;
		int[] colors = new int[4];
		colors[0] = recursion(x, y, size);
		colors[1] = recursion(x + size, y, size);
		colors[2] = recursion(x, y + size, size);
		colors[3] = recursion(x + size, y + size, size);

		int sum = colors[0] + colors[1] + colors[2] + colors[3];

		if (sum == 4) return 1;
		if (sum == -4) return -1;

		for (int i = 0; i < 4; i++) {
			if (colors[i] == 1) blue++;
			else if (colors[i] == -1) white++;
		}

		return 0;
	}
}
