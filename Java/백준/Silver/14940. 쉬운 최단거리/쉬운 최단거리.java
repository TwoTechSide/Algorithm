import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static final int[] dx = new int[] {1, 0, -1, 0};
    public static final int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = readInt(), m = readInt();

        int[][] graph = new int[n][m];
        boolean[][] visitedOrWall = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = readInt();

                if (num == 0)
                    visitedOrWall[i][j] = true;
                else
                    graph[i][j] = -1;

                if (num == 2)
                    queue.add(new int[] {j, i, 0});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int len = cur[2];

            if (!visitedOrWall[y][x]) {
                visitedOrWall[y][x] = true;
                graph[y][x] = len++;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visitedOrWall[ny][nx])
                        continue;

                    queue.add(new int[] {nx, ny, len});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}