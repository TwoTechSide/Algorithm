import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* 19598. 최소 회의실 개수와 완전히 똑같은 문제이므로 자세한 내용 생략 */
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] != o2[0]) { return o1[0] - o2[0]; }
            else { return o1[1] - o2[1]; }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= pq.peek())
                pq.poll();

            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}