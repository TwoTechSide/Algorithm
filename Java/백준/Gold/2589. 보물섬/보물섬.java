import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static final int[] dx = new int[] {1, 0, -1, 0};
    public static final int[] dy = new int[] {0, 1, 0, -1};
    public static boolean[][] map;
    public static int H;
    public static int W;

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void initMap() throws IOException {

        map = new boolean[H][W];
        int c;

        // 육지 - 바다 확인
        for (int y = 0; y < H; y++) {
            for (int x = 0; x <= W; x++) {
                if ((c = System.in.read()) != '\n') {
                    map[y][x] = (c == 'L');
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        H = readInt();
        W = readInt();

        initMap();

        int result = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j]) {
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int startY, int startX) {

        boolean[][] visited = new boolean[H][W];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0});

        int maxLen = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int len = cur[2];

            if (map[y][x] && !visited[y][x]) {
                visited[y][x] = true;

                boolean hasNext = false;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= W || ny < 0 || ny >= H || visited[ny][nx] || !map[ny][nx])
                        continue;

                    queue.add(new int[] {nx, ny, len+1});
                    hasNext = true;
                }

                if (!hasNext) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}