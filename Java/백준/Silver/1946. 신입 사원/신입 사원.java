import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N+1];

            int result = 1;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                rank[idx] = val;
            }

            int minNum = rank[1];

            for (int j = 2; j <= N; j++) {
                if (rank[j] < minNum) {
                    minNum = rank[j];
                    result++;
                }
            }

            bw.write(result+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}