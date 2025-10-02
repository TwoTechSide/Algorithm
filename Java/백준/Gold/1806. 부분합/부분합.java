import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int len = N;
        int sum = 0;

        while (right <= N) {
            if (sum < S) {
                sum += arr[right++];
                // S보다 작으면 오른쪽으로 범위 확장
            } else {
                // S보다 큰 경우 왼쪽에서 범위 축소
                len = Math.min(len, right-left);
                sum -= arr[left++];
            }
        }

        // 왼쪽 시작점이 0이고 모든 합이 S보다 작으면 0으로 반환
        System.out.println((sum < S && left == 0) ? 0 : len);
    }
}