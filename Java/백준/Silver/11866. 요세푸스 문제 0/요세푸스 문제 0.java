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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] arr = new boolean[N];
        int p = -1;

        while (queue.size() < N) {
            for (int i=0; i<K; i++) {
                p = (p + 1) % N;
                if (arr[p]) i--;
            }

            arr[p] = true;
            queue.add(p+1);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            sb.append(queue.remove());
            if (!queue.isEmpty()) sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}