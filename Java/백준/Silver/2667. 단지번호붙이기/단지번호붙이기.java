import java.io.*;
import java.util.*;

public class Main {

    public static final int[] dx = new int[] {1, -1, 0, 0};
    public static final int[] dy = new int[] {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+2][N+2];
        boolean[][] notVisited = new boolean[N+2][N+2];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                graph[i][j] = (str.charAt(j-1) - '0');
                if (graph[i][j] == 1) notVisited[i][j] = true;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (notVisited[i][j]) {
                    q.add(new int[] {i, j});
                    int cnt = 0;

                    while (!q.isEmpty()) {
                        int[] next = q.poll();

                        if (notVisited[next[0]][next[1]]) {
                            notVisited[next[0]][next[1]] = false;
                            cnt++;

                            for (int dir = 0; dir < 4; dir++) {
                                int x = next[1] + dy[dir];
                                int y = next[0] + dx[dir];

                                if (notVisited[y][x])
                                    q.add(new int[] {y, x});
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }

        bw.write(list.size() + "\n");

        list.sort(Comparator.naturalOrder());
        for (int n: list) {
            bw.write(n + "\n");
        }

        bw.flush();

        br.close();
        bw.newLine();
    }
}