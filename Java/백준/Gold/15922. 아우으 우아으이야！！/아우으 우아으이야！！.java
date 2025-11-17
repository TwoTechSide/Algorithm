import java.io.IOException;
import java.util.Collections;
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
		int length = 0;

		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int curLeft = readInt();
			int curRight = readInt();

			if (curLeft <= right)
				right = Math.max(right, curRight);
			else {
				length += right - left;
				left = curLeft;
				right = curRight;
			}
		}

		length += right - left;
		System.out.println(length);
    }
}
