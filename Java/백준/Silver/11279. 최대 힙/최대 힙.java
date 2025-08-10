import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = -Integer.parseInt(br.readLine());
            if (num == 0) {
                bw.write((pq.isEmpty() ? "0\n" : -pq.poll()+"\n"));
            } else {
                pq.add(num);
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}