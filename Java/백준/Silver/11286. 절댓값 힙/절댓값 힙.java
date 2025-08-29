import java.io.*;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> plusPq = new PriorityQueue<>();
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                // 두 pq가 비어있는 경우 0 출력
                if (plusPq.isEmpty() && minusPq.isEmpty()) {
                    bw.write("0\n");
                    continue;
                }

                if (plusPq.isEmpty()) { bw.write(-minusPq.poll() + "\n"); continue; }
                if (minusPq.isEmpty()) { bw.write(plusPq.poll() + "\n"); continue; }

                if (plusPq.peek() < minusPq.peek()) bw.write(plusPq.poll() + "\n");
                else bw.write(-minusPq.poll() + "\n");

                continue;
            }

            if (num > 0) plusPq.add(num);
            else minusPq.add(-num);
        }

        bw.flush();

        br.close();
        bw.close();
    }
}