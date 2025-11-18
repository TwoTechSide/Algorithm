import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

class CircleLine implements Comparable<CircleLine> {
	int left;
	int right;

	public CircleLine(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(CircleLine o) {
		return Integer.compare(this.left, o.left);
	}
}

public class Main {

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
		List<CircleLine> circleLines = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int pos = readInt();
			int len = readInt();
			circleLines.add(new CircleLine(pos-len, pos+len));
		}

		Collections.sort(circleLines);

		Deque<CircleLine> deque = new ArrayDeque<>();
		deque.push(circleLines.get(0));

		for (int i = 1; i < circleLines.size(); i++) {
			CircleLine nc = circleLines.get(i);

			// 불필요한 선분 제거
			while (!deque.isEmpty() && deque.peek().right < nc.left)
				deque.pop();

			// 남아있는 바로 아랫 선분과 비교하여 조건 확인
			if (!deque.isEmpty()) {
				CircleLine pc = deque.peek();

				if (pc.left == nc.left || (pc.right >= nc.left && pc.right <= nc.right)) {
					System.out.println("NO");
					return;
				}
			}

			deque.push(nc);
		}

		System.out.println("YES");
	}
}