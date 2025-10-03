import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) { list.add(new ArrayList<>()); }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        for (List<Integer> l: list) l.sort(Comparator.reverseOrder());

        boolean[] visited = new boolean[N+1];

        // DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(V);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                bw.write(node + " ");

                for (int next: list.get(node)) {
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }

        Arrays.fill(visited, false);
        bw.newLine();

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (!visited[node]) {
                visited[node] = true;
                bw.write(node + " ");

                List<Integer> nextList = list.get(node);
                for (int i = nextList.size()-1; i >= 0; i--) {
                    int next = nextList.get(i);
                    if (!visited[next]) {
                        queue.add(next);
                    }
                }
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}