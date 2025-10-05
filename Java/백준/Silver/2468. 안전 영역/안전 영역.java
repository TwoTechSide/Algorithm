import java.io.*;
import java.util.*;

public class Main {

    public static final int[] dx = new int[] { 1, 0, -1, 0};
    public static final int[] dy = new int[] { 0, 1, 0, -1};

    public static int[][] graph;
    public static boolean[][] visited;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                numSet.add(graph[i][j]);
            }
        }

        // 만약 모든 지형의 높이가 같은 경우
        if (numSet.size() == 1) {
            System.out.println(1);
            return;
        }

        int maxAreaCnt = 0;

        for (int height: numSet) {

            // 각 높이마다 계산할 때 visited 초기화
            for (boolean[] row: visited)
                Arrays.fill(row, false);

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    count += bfs(j, i, height);
                }
            }

            maxAreaCnt = Math.max(maxAreaCnt, count);
        }

        System.out.println(maxAreaCnt);
    }

    public static int bfs(int x, int y, int height) {

        if (visited[y][x] || graph[y][x] <= height)
            return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int px = cur[0];
            int py = cur[1];

            if (!visited[py][px]) {
                visited[py][px] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[ny][nx] <= height)
                        continue;

                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return 1;
    }
}