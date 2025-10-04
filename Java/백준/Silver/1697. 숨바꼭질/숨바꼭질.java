import java.io.*;
import java.util.*;

public class Main {

    public static boolean flag = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N-K);
            return;
        }

        int[] arr = new int[100_001];
        Arrays.fill(arr, 0);

        arr[N] = -1;
        arr[K] = -2;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {N, 0});

        while (!queue.isEmpty() && flag) {
            int[] cur = queue.poll();
            int curPos = cur[0];
            int curCnt = cur[1] + 1;
            nextStep(arr, queue, curPos+1, curCnt);
            nextStep(arr, queue, curPos-1, curCnt);
            nextStep(arr, queue, curPos*2, curCnt);
        }
    }

    public static void nextStep(int[] arr, Queue<int[]> queue, int pos, int cnt) {

        if (pos > 100_000 || pos < 0 || !flag)
            return;

        if (arr[pos] == -2) {
            System.out.println(cnt);
            flag = false;
            return;
        }

        if (arr[pos] == 0) {
            arr[pos] = cnt;
            queue.offer(new int[] {pos, cnt});
        }
    }
}