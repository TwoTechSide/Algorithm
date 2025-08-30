import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sumArr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        sumArr[0] = 0;
        for (int i = 1; i <= N; i++) sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <= N; j++) {
                int d = sumArr[j] - sumArr[i];
                if (d >= M) {
                    if (d == M) result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}