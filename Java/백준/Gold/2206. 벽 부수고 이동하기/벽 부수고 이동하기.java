import java.io.*;
import java.util.*;

enum stat {
    NEW,
    V,
    W,
    WALL
}

class Node {
    int x;
    int y;
    int len;
    boolean passed;

    Node() {
        this(0, 0, 1, false);
    }

    Node(int x, int y, int len, boolean passed) {
        this.x = x;
        this.y = y;
        this.len = len;
        this.passed = passed;
    }
}

public class Main {

    public static final int[] dx = new int[] { 1, 0, -1, 0 };
    public static final int[] dy = new int[] { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 문제 풀이
        // 이미 벽을 통과한 노드 v와 통과하지 않은 노드 w는 별개로 진행
        // v -> 새로운 길이 아닌 경우 모두 break
        // w -> 이미 지나간 길이면 break (v가 지나간 길은 X)
        // 각 자리에 대해 [ 새로운 길 / v가 지나간 길 / w가 지나간 길 / 벽 ] 4가지로 확인

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        stat[][] graph = new stat[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = (str.charAt(j) == '0') ? stat.NEW : stat.WALL;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node());

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cx = node.x;
            int cy = node.y;

            // 목적지에 도착한 경우 return
            if (cx == M-1 && cy == N-1) {
                System.out.println(node.len);
                return;
            }

            // W -> 새로운 길에만 진행
            if (node.passed) {
                if (graph[cy][cx] != stat.NEW) continue;
                graph[cy][cx] = stat.W;
            }

            // V -> 이미 지나친 길이 아닌 경우에만 진행, 벽인 경우 passed = true
            if (!node.passed) {
                if (graph[cy][cx] == stat.V) continue;
                else if (graph[cy][cx] == stat.WALL) node.passed = true;
                graph[cy][cx] = stat.V;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;

                queue.add(new Node(nx, ny, node.len+1, node.passed));
            }
        }

        System.out.println(-1);
        br.close();
    }
}