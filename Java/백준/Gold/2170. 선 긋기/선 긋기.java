import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static int readInt() throws IOException {
		int c = System.in.read();
		boolean negative = false;

		if (c == '-') {
			negative = true;
			c = System.in.read();
		}

		int n = c & 15;

		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return negative ? -n : n;
	}

    public static void main(String[] args) throws IOException {

		int N = readInt();
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i][0] = readInt();
			arr[i][1] = readInt();
		}

		Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

		int prevStart = arr[0][0];
		int prevEnd = arr[0][1];
		int nextStart;
		int nextEnd;
		int result = 0;

		for (int i = 1; i < N; i++) {
			int[] next = arr[i];
			nextStart = next[0];
			nextEnd = next[1];

			if (nextStart <= prevEnd)
				prevEnd = Math.max(prevEnd, nextEnd);

			else {
				result += prevEnd - prevStart;
				prevStart = nextStart;
				prevEnd = nextEnd;
			}
		}

		result += prevEnd - prevStart;
		System.out.println(result);
    }
}
