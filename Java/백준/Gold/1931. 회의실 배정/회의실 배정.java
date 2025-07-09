import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 회의의 수 N
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];

        // N개의 회의의 시작시간과 끝나는 시간 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken()); // 시작하는 시간
            times[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }

        // 끝나는 시간 정렬, 같으면 시작 시간 정렬
        Arrays.sort(times, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int count = 0;
        int index = 0;
        int beforeEndTime = 0;

        while(index < N) {

            int startTime = times[index][0];
            int endTime = times[index][1];

            /* 로그 */
            // System.out.println("start: " + startTime + " end: " + endTime);

            // 이전 회의 시간 이후로 진행되는 경우, 다음 회의의 끝나는 시간 순서로 확인하면서 카운트
            if (startTime >= beforeEndTime) {
                beforeEndTime = endTime;
                count++;
            }

            index++;
        }

        bw.write(String.valueOf(count));
        bw.flush();

        br.close();
        bw.close();
    }
}