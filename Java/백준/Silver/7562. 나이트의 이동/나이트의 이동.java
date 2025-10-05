import java.io.*;
import java.util.*;

public class Main {

    public static final int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public static final int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // 시작 위치와 목적지가 같은 경우
            if (startX == endX && startY == endY) {
                bw.write("0\n");
                continue;
            }

            int cnt = bfs(N, startX, startY, endX, endY);
            bw.write(cnt + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int bfs(int N, int startX, int startY, int endX, int endY) {

        boolean[][] board = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            // 목표에 도착한 경우 return
            if (x == endX && y == endY)
                return cnt;

            if (!board[y][x]) {
                board[y][x] = true;

                cnt++;

                for (int next = 0; next < 8; next++) {
                    int nx = x + dx[next];
                    int ny = y + dy[next];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[ny][nx])
                        continue;

                    queue.add(new int[] {nx, ny, cnt});
                }
            }
        }

        return 0;
    }
}