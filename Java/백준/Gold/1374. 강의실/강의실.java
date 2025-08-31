import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // [ 11000. 강의실 배정, 19598 최소 회의실 개수 ]와 비슷한 문제이므로 자세한 내용 생략
        // result 로직만 살짝 다름

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) { return o1[2] - o2[2]; }
            else { return o1[1] - o2[1]; }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 1;

        pq.add(arr[0][2]);

        for (int i = 1; i < N; i++) {
            if (arr[i][1] >= pq.peek()) pq.poll();
            else result++;

            pq.offer(arr[i][2]);
        }

        System.out.println(result);
    }
}