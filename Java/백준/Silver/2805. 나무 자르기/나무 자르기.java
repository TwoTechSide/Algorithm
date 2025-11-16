import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		int[] trees = new int[N];

		long max = Long.MIN_VALUE;
		long min = 0;

		for (int i = 0; i < N; i++) {
			if (max < (trees[i] = readInt()))
				max = trees[i];
		}

		// 이진 탐색
		while (min < max) {
			long sum = 0;
			long mid = (min + max) / 2;

			for (int height: trees)
				sum += Math.max(0, height - mid);

			if (sum >= M) min = mid + 1;
			else max = mid;
		}

		System.out.println(min-1);
    }
}
