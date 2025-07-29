import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb;
    static int[] arr;

    public static void backTracking(int N, int depth) {
        // arr에 값을 모두 채운 경우 StringBuilder에 append
        if (depth == M) {
            for (int n : arr) sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        // 1부터 N까지 순회 고정
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            backTracking(N, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        backTracking(N, 0);

        System.out.println(sb);
    }
}