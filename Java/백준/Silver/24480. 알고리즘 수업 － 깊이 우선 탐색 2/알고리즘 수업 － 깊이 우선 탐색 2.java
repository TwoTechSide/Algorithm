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

        // 깊이 우선 탐색 1에서 PriorityQueue의 정렬 순서만 reverse -> natural
        List<PriorityQueue<Integer>> list = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) { list.add(i, new PriorityQueue<>()); }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        int[] orderArr = new int[N+1];
        Arrays.fill(orderArr, 0);

        Stack<Integer> stack = new Stack<>();
        stack.push(R);

        int index = 1;

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (orderArr[cur] == 0) {

                orderArr[cur] = index++;

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