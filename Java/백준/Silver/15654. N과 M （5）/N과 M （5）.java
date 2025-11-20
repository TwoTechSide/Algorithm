import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static int N;
	public static int M;

	public static int[] numArr;
	public static int[] idxArr;
	public static boolean[] visitied;

	public static void backTracking(int depth) {

		if (depth == M) {

			for (int i = 0; i < M; i++)
				sb.append(numArr[idxArr[i]]).append(" ");

			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visitied[i]) {
				visitied[i] = true;
				idxArr[depth] = i;
				backTracking(depth + 1);
				visitied[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = readInt();
		M = readInt();

		numArr = new int[N];
		idxArr = new int[M];
		visitied = new boolean[N];

		for (int i = 0; i < N; i++)
			numArr[i] = readInt();

		Arrays.sort(numArr);

		backTracking(0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}