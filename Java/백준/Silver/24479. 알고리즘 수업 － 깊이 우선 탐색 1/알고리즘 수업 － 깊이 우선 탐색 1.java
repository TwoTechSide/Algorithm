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
        int R = Integer.parseInt(st.nextToken());

        // 연결된 정점
        List<PriorityQueue<Integer>> list = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) { list.add(i, new PriorityQueue<>(Collections.reverseOrder())); }

        // 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        // 각 숫자가 지나는 순서 입력
        int[] orderArr = new int[N+1];
        Arrays.fill(orderArr, 0);

        // DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(R);

        int index = 1;

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            // 방문하지 않은 경우 -> orderArr[?] == 0
            if (orderArr[cur] == 0) {

                orderArr[cur] = index++;

                // 해당 정점에서의 연결된 수를 가져온 뒤, 방문하지 않은 연결된 노드들을 stack에 push
                PriorityQueue<Integer> curPq = list.get(cur);

                while (!curPq.isEmpty()) {
                    int next = curPq.poll();

                    if (orderArr[next] == 0) {
                        stack.push(next);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(orderArr[i] + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}