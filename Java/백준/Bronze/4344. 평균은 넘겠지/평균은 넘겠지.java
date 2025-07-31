import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            float average = 0;
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                average += arr[j];
            }

            average /= (float) N;

            for (int j = 0; j < N; j++) {
                if (arr[j] > average) cnt++;
            }

            bw.write(String.format("%.3f", cnt * 100 / (float) N)+"%\n");
        }

        br.close();
        bw.close();
    }
}