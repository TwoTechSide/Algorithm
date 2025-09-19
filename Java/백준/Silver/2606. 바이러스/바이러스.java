import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 간선 리스트
        List<Integer>[] list = new ArrayList[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            list[from].add(to);
            list[to].add(from);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int result = 0;

        // Stack DFS 탐색, 새로운 노드에 접근시 result++;
        while(!stack.isEmpty()) {
            int c = stack.pop();

            if (!visited[c]) {
                visited[c] = true;
                result++;

                for(int next: list[c]) {
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }

        System.out.println(result-1);   // 1번 컴퓨터를 제외한 결과 출력
    }
}