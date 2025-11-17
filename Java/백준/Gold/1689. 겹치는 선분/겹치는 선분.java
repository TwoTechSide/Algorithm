import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point implements Comparable<Point> {
	int point;
	int isEnd;

	Point(int point, int isEnd) {
		this.point = point;
		this.isEnd = isEnd;
	}

	@Override
	public int compareTo(Point o) {
		if (this.point != o.point) return this.point - o.point;
		else return o.isEnd - isEnd;	// 같은 위치인 경우, 끝점이 먼저 올 필요가 있음
	}

}

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
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			points.add(new Point(readInt(), 0));
			points.add(new Point(readInt(), 1));
		}

		Collections.sort(points);

		int cnt = 0;
		int maxCnt = 0;

		for (Point p : points) {
			// 시작점이면 +1, 끝점이면 -1
			if (p.isEnd == 0) {
				cnt++;
				maxCnt = Math.max(maxCnt, cnt);
			} else {
				cnt--;
			}
		}

		System.out.println(maxCnt);
    }
}
