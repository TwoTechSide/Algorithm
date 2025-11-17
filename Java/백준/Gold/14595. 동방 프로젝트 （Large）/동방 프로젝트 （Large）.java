import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point implements Comparable<Point> {
	int point;
	int isEnd;

	public Point(int point, int isEnd) {
		this.point = point;
		this.isEnd = isEnd;
	}

	@Override
	public int compareTo(Point o) {
		if (this.point != o.point) return this.point - o.point;
		else return o.isEnd - this.isEnd;
	}
}

public class Main {

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException {

		int N = readInt();
		int M = readInt();
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			points.add(new Point(readInt(), 1));
			points.add(new Point(readInt(), -1));
		}

		Collections.sort(points);

		int cnt = 0;
		int startPoint = 0;

		for (Point p : points) {

			if (cnt == 0)
				startPoint = p.point;

			cnt += p.isEnd;

			if (cnt == 0)
				N -= p.point - startPoint;
		}

		System.out.println(N);
    }
}
