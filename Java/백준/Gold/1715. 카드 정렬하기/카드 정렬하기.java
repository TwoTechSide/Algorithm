import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        int result = 0;

        // 묶음이 2개 이상인 경우
        // 1개만 남을 때까지 가장 작은 묶음 2개를 합쳐서 다시 PriorityQueue에 add, 더하는 값을 result에 누적
        while (pq.size() > 1) {
            int num = pq.poll() + pq.poll();
            pq.add(num);

            result += num;
        }

        System.out.println(result);

        br.close();
    }
}