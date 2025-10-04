import java.io.*;
import java.util.*;

public class Main {

    public static final int[] dx = new int[] {1, 0, -1, 0};
    public static final int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs(graph, N, M));
    }

    public static int bfs(char[][] graph, int N, int M) {
        // 큐 생성 및 시작점 주입
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1}); // (x, y, len)

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N-1 && cur[1] == M-1) {
                return cur[2];
            }

            if (graph[cur[0]][cur[1]] == '1') {
                graph[cur[0]][cur[1]] = '0';

                for (int i = 0; i < 4; i++) {
                    int nextX = cur[1] + dx[i];
                    int nextY = cur[0] + dy[i];

                    if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                        queue.add(new int[] {nextY, nextX, cur[2]+1});
                    }
                }
            }
        }

        return -1;
    }
}