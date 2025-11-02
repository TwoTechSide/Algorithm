import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static Integer readInt() throws IOException {

        int c = System.in.read();
        boolean negative;

        if (c == '-') {
            negative = true;
            c = System.in.read();
        } else {
            negative = false;
        }

        int n = c & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return negative ? -n : n;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = readInt();
        boolean[] isValid = new boolean[2_001];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {

            int num = readInt();

            if (!isValid[num+1_000]) {
                isValid[num+1_000] = true;
                pq.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty())
            sb.append(pq.poll()).append(" ");

        System.out.println(sb);
    }
}