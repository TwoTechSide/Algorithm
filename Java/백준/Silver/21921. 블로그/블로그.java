import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i <= N; i++) {
            // 누적합
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

            if (i >= X) {
                pq.add(arr[i] - arr[i-X]);
            }
        }

        // 최대 방문자 수가 0명인 경우
        if (!pq.isEmpty()) {
            int maxNum = pq.peek();

            if (maxNum == 0) {
                System.out.println("SAD");
                return;
            }

            int cnt = 0;

            while (!pq.isEmpty() && pq.peek() == maxNum) {
                pq.poll();
                cnt++;
            }

            sb.append(maxNum).append("\n");
            sb.append(cnt);

            System.out.println(sb);
        }
    }
}