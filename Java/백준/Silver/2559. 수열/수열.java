import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());

        int maxNum = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++)
            maxNum = Math.max(maxNum, sum[i] - sum[i-K]);

        bw.write(maxNum+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}