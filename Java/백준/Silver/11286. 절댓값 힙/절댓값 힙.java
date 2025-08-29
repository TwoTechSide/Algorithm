import java.io.*;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // pq의 우선 순위 방법에 해당 문제 로직 구현
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1) == Math.abs(n2)) { return Integer.compare(n1, n2); }
            else { return Integer.compare(Math.abs(n1), Math.abs(n2)); }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) { bw.write("0\n"); }
                else { bw.write(pq.poll() + "\n"); }
                continue;
            }

            pq.offer(num);
        }

        bw.flush();

        br.close();
        bw.close();
    }
}