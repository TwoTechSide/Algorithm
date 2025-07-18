import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 문제 풀이
        // 1. 누적합을 저장할 dp 생성
        // 2. for 문으로 누적합 진행, 만약 dp의 누적합이 기본값보다 작으면 dp를 기본값으로 초기화
        // 3. 가장 크게 저장되었던 dp값 출력
        int dp = arr[0];
        int result = dp;

        for (int i = 1; i < n; i++) {
            dp = Math.max(arr[i], dp + arr[i]);
            result = Math.max(result, dp);
        }

        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}