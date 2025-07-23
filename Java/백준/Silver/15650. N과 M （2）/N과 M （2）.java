import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    static BufferedReader br;

    public static void backTracking(int startPos, int depth) throws IOException {
        if (depth == M) {
            for (int n : arr)
                bw.write(n + " ");

            bw.newLine();
            return;
        }

        for (int i = startPos; i <= N; i++) {
            arr[depth] = i;
            backTracking(i+1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        backTracking(1, 0);
        bw.flush();

        br.close();
        bw.close();
    }
}