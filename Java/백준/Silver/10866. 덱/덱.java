import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            switch (input) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write((deque.isEmpty() ? "-1" : deque.removeFirst()) + "\n");
                    break;
                case "pop_back":
                    bw.write((deque.isEmpty() ? "-1" : deque.removeLast()) + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write((deque.isEmpty() ? "1" : "0") + "\n");
                    break;
                case "front":
                    bw.write((deque.isEmpty() ? "-1" : deque.getFirst()) + "\n");
                    break;
                case "back":
                    bw.write((deque.isEmpty() ? "-1" : deque.getLast()) + "\n");
                    break;
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}