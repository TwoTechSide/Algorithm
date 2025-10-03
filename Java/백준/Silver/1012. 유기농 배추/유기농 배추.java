import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = new int[] {1, -1, 0, 0};
    static final int[] dy = new int[] {0, 0, 1, -1};

    static boolean[][] notVisited;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            notVisited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                notVisited[y][x] = true;
            }

            int count = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (notVisited[y][x]) {
                        bfs(y, x);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static void bfs(int y, int x) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            x = cur[1];
            y = cur[0];

            if (notVisited[y][x]) {
                notVisited[y][x] = false;

                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && notVisited[nextY][nextX])
                        queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }
}