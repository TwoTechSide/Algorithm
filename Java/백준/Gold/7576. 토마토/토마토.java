import java.io.*;
import java.util.*;

public class Main {

    public static final int[] dx = new int[] {1, 0, -1, 0};
    public static final int[] dy = new int[] {0, 1, 0, -1};

    public static int crudeCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) { q.add(new int[] {i, j, 0}); }
                else if (graph[i][j] == 0) { crudeCount++; }
            }
        }

        crudeCount += q.size();
        int day = bfs(graph, q);

        System.out.println(crudeCount == 0 ? day : -1);
    }

    public static int bfs(int[][] graph, Queue<int[]> q) {

        int day = 0;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[1];
            int y = c[0];
            int curDay = c[2];

            if (curDay == 0 || graph[y][x] == 0) {
                graph[y][x] = 1;
                day = curDay;
                crudeCount--;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < graph[0].length && ny >= 0 && ny < graph.length)
                        q.add(new int[] {ny, nx, curDay+1});
                }
            }
        }

        return day;
    }
}