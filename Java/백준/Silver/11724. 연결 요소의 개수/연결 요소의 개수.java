import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[N+1];
        boolean[] visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) { list[i] = new ArrayList<>(); }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                q.add(i);

                while (!q.isEmpty()) {
                    int cur = q.poll();

                    if (!visited[cur]) {
                        visited[cur] = true;

                        for (int next: list[cur]) {
                            if (!visited[next])
                                q.add(next);
                        }
                    }
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}