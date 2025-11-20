import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node {
		int value;
		boolean removed;

		public Node(int value) {
			this.value = value;
			this.removed = false;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Node> pq1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.value, o1.value));
			PriorityQueue<Node> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));

			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (command.equals("I")) {
					Node node = new Node(num);
					pq1.offer(node);
					pq2.offer(node);
				}

				else if (command.equals("D")) {

					if (pq1.isEmpty() && pq2.isEmpty())
						continue;

					if (num == 1) {
						while (!pq1.isEmpty() && pq1.peek().removed) pq1.poll();
						if (!pq1.isEmpty()) pq1.poll().removed = true;
					} else {
						while (!pq2.isEmpty() && pq2.peek().removed) pq2.poll();
						if (!pq2.isEmpty()) pq2.poll().removed = true;
					}
				}
			}

			while (!pq1.isEmpty() && pq1.peek().removed) pq1.poll();
			while (!pq2.isEmpty() && pq2.peek().removed) pq2.poll();

			if (pq1.isEmpty() || pq2.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(pq1.peek().value).append(" ").append(pq2.peek().value).append("\n");
			}
		}

		System.out.println(sb);
	}
}