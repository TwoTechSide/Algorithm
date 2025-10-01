import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> m = new PriorityQueue<>();
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());

        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num <= 0) m.add(num);
            else if (num == 1) result++;    // 1 * 1보다 1 + 1이 크기 때문에 덧셈
            else p.add(num);
        }

        while (m.size() > 1)
            result += m.poll() * m.poll();

        while (p.size() > 1)
            result += p.poll() * p.poll();

        if (!m.isEmpty())
            result += m.poll();

        if (!p.isEmpty())
            result += p.poll();

        System.out.println(result);
    }
}