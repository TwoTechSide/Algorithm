import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static boolean[] visited;
    public static int[] arr;

    public static void backTracking(int depth) {

        if (depth == N) {
            for (int n : arr) sb.append(n).append(" ");
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i-1]) {
                visited[i-1] = true;
                arr[depth] = i;
                backTracking(depth + 1);
                visited[i-1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N];

        backTracking(0);

        System.out.print(sb);
    }
}