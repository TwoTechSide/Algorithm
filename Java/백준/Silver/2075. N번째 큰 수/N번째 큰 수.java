import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        boolean[] unnecessary = new boolean[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(5);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == N-1) pq.add(arr[i][j]);
            }
        }

        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (unnecessary[j]) continue;

                if (arr[i][j] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i][j]);
                } else {
                    unnecessary[j] = true;
                }
            }
        }

        System.out.println(pq.peek());
    }
}