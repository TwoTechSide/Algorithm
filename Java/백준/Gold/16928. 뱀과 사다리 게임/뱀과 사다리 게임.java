import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[101];
        int[] cntArr = new int[101];
        Arrays.fill(arr, 0);
        Arrays.fill(cntArr, 0);

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = N+M;

        for (int i = 0; i < sum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from] = to;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1,0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos >= 94 && arr[pos] == 0) {
                System.out.println(cnt+1);
                return;
            }

            if (cntArr[pos] == 0) {
                cntArr[pos] = cur[1];
                cnt++;

                for (int i = 1; i <= 6; i++) {
                    int nextPos = pos + i;
                    if (arr[nextPos] != 0) { nextPos = arr[nextPos]; }

                    queue.add(new int[] {nextPos, cnt});
                }
            }
        }

        br.close();
    }
}