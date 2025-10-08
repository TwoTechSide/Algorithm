import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int testcase = 1 << N;

        int minDiff = Integer.MAX_VALUE;

        while (--testcase > 0) {
            int sour = 1;
            int bitter = 0;

            for (int i = 1; i <= N; i++) {
                if ((1 << (i-1) & testcase) > 0) {
                    sour *= arr[i][0];
                    bitter += arr[i][1];
                }
            }

            minDiff = Math.min(minDiff, Math.abs(bitter - sour));
        }

        System.out.println(minDiff);
    }
}