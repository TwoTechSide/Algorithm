import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] preSum = new int[N+1][M+1];

        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                int num = Integer.parseInt(st.nextToken());
                preSum[y][x] = preSum[y-1][x] + preSum[y][x-1] - preSum[y-1][x-1] + num;
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int n = 0; n < K; n++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = preSum[i-1][j-1] - preSum[i-1][y] - preSum[x][j-1] + preSum[x][y];
            bw.write(result + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}