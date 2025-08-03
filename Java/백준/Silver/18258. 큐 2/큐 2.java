import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int backNum = 0;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    backNum = Integer.parseInt(st.nextToken());
                    queue.add(backNum);
                    break;
                case "pop":
                    sb.append((!queue.isEmpty()) ? queue.poll() : -1);
                    break;
                case "size":
                    sb.append(queue.size());
                    break;
                case "empty":
                    sb.append((queue.isEmpty()) ? 1 : 0);
                    break;
                case "front":
                    sb.append((!queue.isEmpty()) ? queue.peek() : -1);
                    break;
                case "back":
                    sb.append((!queue.isEmpty()) ? backNum : -1);
            }
            if (!str.equals("push")) sb.append("\n");
        }
        System.out.print(sb);
    }
}