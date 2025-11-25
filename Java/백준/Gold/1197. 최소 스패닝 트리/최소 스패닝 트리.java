import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void union(int[] parent, int[] rank, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);

		if (x == y) return;

		// Union By Rank로 최적화
		if (rank[x] < rank[y]) parent[x] = y;
		else if (rank[x] > rank[y]) parent[y] = x;
		else {
			parent[y] = x;
			rank[x]++;
		}
	}

	public static int find(int[] parent, int x) {
		if (parent[x] == x) return x;
		else return find(parent, parent[x]);
	}

	public static void kruskal(int[][] graph, int[] parent, int[] rank) {
		int cost = 0;

		for (int i = 0; i < graph.length; i++) {
			// 4. 두 정점의 부모가 같지 않은 경우 가중치 누적 및 같은 최소 스패닝 트리에 속하도록 설정
			if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
				cost += graph[i][2];
				union(parent, rank, graph[i][0], graph[i][1]);
			}
		}

		System.out.println(cost);
	}

	public static void main(String[] args) throws IOException {

		int V = readInt(), E = readInt();
		int[][] graph = new int[E][3];

		for (int i = 0; i < E; i++) {
			graph[i][0] = readInt();
			graph[i][1] = readInt();
			graph[i][2] = readInt();
		}

		// 1. 가중치를 오름차순으로 정렬
		Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

		// 2. 각 노드에 대해 부모 노드를 저장할 배열 생성 및 자기 자신으로 초기화
		int[] parent = new int[V+1];
		int[] rank = new int[V+1];
		for (int i = 0; i < parent.length; i++) parent[i] = i;

		// 3. 크루스칼 알고리즘 진행
		kruskal(graph, parent, rank);
	}

	public static int readInt() throws IOException {
		int c = System.in.read();
		boolean negative = (c == '-');

		if (negative) c = System.in.read();
		int n = c & 15;

		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return negative ? -n : n;
	}
}