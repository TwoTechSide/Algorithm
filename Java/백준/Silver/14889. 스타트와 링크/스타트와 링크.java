import java.io.IOException;

public class Main {

    public static int N;

    public static int[][] graph;

    public static boolean[] joined;
    public static int result = Integer.MAX_VALUE;

    public static void backTracking(int index, int depth) {

        if (result == 0)
            return;

        if (depth == N/2) {
            int s = 0, l = 0;

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (joined[i] && joined[j])
                        s += graph[i][j] + graph[j][i];
                    else if (!joined[i] && !joined[j])
                        l += graph[i][j] + graph[j][i];
                }
            }

            result = Math.min(result, Math.abs(s - l));
        }

        for (int i = index; i < N; i++) {
            if (!joined[i]) {
                joined[i] = true;
                backTracking(i + 1,depth + 1);
                joined[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        N = readInt();

        graph = new int[N][N];
        joined = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = readInt();
            }
        }

        backTracking(0, 0);

        System.out.println(result);
    }

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}