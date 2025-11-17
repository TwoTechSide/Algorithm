import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static int readInt() throws IOException {
		int c = System.in.read();
		boolean negative = (c == '-');

		if (negative) c = System.in.read();
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

		PriorityQueue<Integer> endPoints = new PriorityQueue<>();
		int maxCnt = 0;

		for (int i = 0; i < N; i++) {

			// 겹치지 않는 선분들 제거
			while (!endPoints.isEmpty() && arr[i][0] >= endPoints.peek())
				endPoints.poll();

			endPoints.add(arr[i][1]);
			maxCnt = Math.max(maxCnt, endPoints.size());
		}

		System.out.println(maxCnt);
    }
}
