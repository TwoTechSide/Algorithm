import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());

            // String 기준 오름차순 정렬
            PriorityQueue<String> pq = new PriorityQueue<>(Comparator.naturalOrder());

            for (int i = 0; i < N; i++)
                pq.add(br.readLine());

            String prev = pq.poll();
            String next;

            boolean isValid = true;

            while (!pq.isEmpty()) {
                next = pq.poll();

                if (prev.length() < next.length()) {
                    int index = 0;
                    while (index < prev.length()) {
                        if (prev.charAt(index) != next.charAt(index)) {
                            break;
                        }
                        index++;
                    }

                    if (index == prev.length()) {
                        isValid = false;
                        break;
                    }
                }

                prev = next;
            }

            bw.write(isValid ? "YES\n" : "NO\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}