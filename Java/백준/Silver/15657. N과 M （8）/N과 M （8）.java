import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int[] arr;
    static int[] output_arr;
    static StringBuilder sb = new StringBuilder();
    static int idx = 0;

    public static void backTracking(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output_arr[i]);

                if (i == M-1)
                    sb.append("\n");
                else
                    sb.append(" ");
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            output_arr[depth] = arr[i];
            idx = i;
            backTracking(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output_arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        backTracking(0);

        System.out.print(sb);
    }
}