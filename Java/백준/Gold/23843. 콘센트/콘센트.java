import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 만약 N < M인 경우, 가장 큰 값을 출력하고 종료
        if (N <= M) {
            int result = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) { result = Math.max(result, Integer.parseInt(st.nextToken())); }

            System.out.println(result);
        } else {
            // arr에 값을 모두 넣은 뒤 역순 정렬
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
            Arrays.sort(arr, Collections.reverseOrder());

            // M개의 콘센트 시간을 저장할 PriorityQueue 생성
            PriorityQueue<Long> pqTime = new PriorityQueue<>();

            // M개의 값을 넣은 뒤, 가장 작은 값에 값을 더하는 로직을 반복 수행
            for (int num : arr) {
                if (pqTime.size() < M) pqTime.add((long) num);
                else pqTime.add(pqTime.poll() + num);
            }

            // 사용된 시간이 가장 큰 값을 출력
            long maxNum = 0;
            for (long n : pqTime) maxNum = Math.max(maxNum, n);

            System.out.println(maxNum);
        }

        br.close();
    }
}