import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

		for (int i = 0; i < N; i++)
			pq.add(new int[] {readInt(), readInt()});

		int prevStart = pq.peek()[0];
		int prevEnd = pq.poll()[1];
		int nextStart;
		int nextEnd;
		int result = 0;

		while (!pq.isEmpty()) {
			nextStart = pq.peek()[0];
			nextEnd = pq.poll()[1];

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
