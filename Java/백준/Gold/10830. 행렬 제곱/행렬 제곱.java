import java.io.IOException;

public class Main {

	public static final int mod = 1_000;
	public static int N;
	public static int[][] A;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		N = readInt();
		long B = readLong();

		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = readInt() % mod;
			}
		}

		// B = 1인 경우
		int[][] result = powMatrix(B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static int[][] powMatrix(long B) {
		int[][] res;

		if (B == 1) {
			res = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res[i][j] = A[i][j];
				}
			}

			return res;
		}

		// 분할 정복을 이용한 거듭제곱 알고리즘 사용
		int[][] prev = powMatrix(B/2);

		res = multiplyMatrix(prev, prev);
		if ((B & 1) == 1) res = multiplyMatrix(res, A);

		return res;
	}

	public static int[][] multiplyMatrix(int[][] A, int[][] B) {
		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					matrix[i][j] += A[i][k] * B[k][j];
					matrix[i][j] %= mod;
				}
			}
		}

		return matrix;
	}

	public static long readLong() throws IOException {
		int c;
		long n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = ((n << 3) + (n << 1) + (c & 15));
		return n;
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = ((n << 3) + (n << 1) + (c & 15));
		return n;
	}
}