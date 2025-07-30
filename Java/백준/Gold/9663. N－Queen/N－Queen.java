import java.io.*;

public class Main {

    public static int N;
    public static int[] arr;
    public static int result = 0;

    public static boolean isPossible(int col) {

        for (int i = 0; i < col; i++) {

            // 같은 행에 있는 경우
            if (arr[col] == arr[i])
                return false;

            // 대각선에 있는 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }

        return true;
    }

    public static void backTracking(int depth) {

        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // i     : 행
            // depth : 열
            arr[depth] = i;
            if (isPossible(depth)) {
                backTracking(depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 문제 풀이
        // 퀸은 행 또는 열마다 1개씩 배치되어야 하므로 이 부분을 중점으로 시간 복잡도를 줄이는 것이 핵심
        arr = new int[N];
        backTracking(0);

        System.out.println(result);
    }
}