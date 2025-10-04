import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int[] dx = new int[] { 1, 0, -1, 0, 0, 0 };
    public static final int[] dy = new int[] { 0, 1, 0, -1, 0, 0 };
    public static final int[] dz = new int[] { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[K][N][M];
        Queue<int[]> queue = new LinkedList<>();

        int crudeCnt = 0;
        int day = 0;

        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[k][i][j] = num;

                    if (num == 0) { crudeCnt++; }
                    else if (num == 1) { queue.add(new int[] { j, i, k, 0 }); }
                }
            }
        }

        if (crudeCnt == 0) {
            System.out.println("0");
            return;
        }

        crudeCnt += queue.size();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            int nextDay = cur[3];

            if (arr[z][y][x] != -1) {
                arr[z][y][x] = -1;
                crudeCnt--;
                day = nextDay;

                for (int i = 0; i < 6; i++) {

                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= K)
                        continue;

                    queue.add(new int[] { nx, ny, nz, nextDay+1 });
                }
            }
        }

        System.out.println(crudeCnt == 0 ? day : -1);
    }
}