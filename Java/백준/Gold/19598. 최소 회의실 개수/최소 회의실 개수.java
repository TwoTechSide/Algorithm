import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1차 시작시간 오름차순 정렬
        // 2차 종료시간 오름차순 정렬
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[0] != o2[0]) { return o1[0] - o2[0]; }
            else { return o1[1] - o2[1]; }
        });

        // 각 회의실의 끝나는 시간 기준 우선순위 Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(meetings[0][1]);
        for (int i = 1; i < N; i++) {

            // 만약 가장 빨리 끝나는 회의실에 배정할 수 있으면 해당 회의실에 배정 (이전 회의를 poll 하고 새로운 회의를 add <- 해당 회의실의 끝나는 시간 업데이트)
            // 아닌 경우, 새로운 회의실을 배정한다는 뜻으로 pq.add만 작동
            if (meetings[i][0] >= pq.peek())
                pq.poll();

            pq.add(meetings[i][1]);
        }

        bw.write(pq.size()+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}