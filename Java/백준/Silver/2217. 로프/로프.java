import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for (int i = 0; i < N; i++) pq1.add(Integer.parseInt(br.readLine()));

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        while (!pq1.isEmpty()) { pq2.add(pq1.size() * pq1.poll()); }

        System.out.println(pq2.poll());
    }
}