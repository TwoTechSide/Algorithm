import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

	static class Point implements Comparable<Point> {
		int x;
		int index;
		boolean isOpen;

		public Point(int x, int index, boolean isOpen) {
			this.x = x;
			this.index = index;
			this.isOpen = isOpen;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x != o.x) return Integer.compare(this.x, o.x);
			return Boolean.compare(o.isOpen, this.isOpen);
		}

	}

	public static int readInt() throws IOException {
		int c = System.in.read();
		boolean neg = (c == '-');

		if (neg) c = System.in.read();

		int n = c & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return neg ? -n : n;
	}

    public static void main(String[] args) throws IOException {
		int N = readInt();
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int pos = readInt();
			int rad = readInt();
			points.add(new Point(pos-rad, i, true));
			points.add(new Point(pos+rad, i, false));
		}

		Collections.sort(points);

		Deque<Integer> stack = new ArrayDeque<>();

		for (Point p : points) {
			if (p.isOpen) {
				stack.push(p.index);
			} else {
				if (stack.isEmpty() || stack.peek() != p.index) {
					System.out.println("NO");
					return;
				}
				stack.pop();
			}
		}

		System.out.println("YES");
    }
}
