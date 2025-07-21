import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] checked;

    public static void backTracking(int depth, BufferedWriter bw) throws IOException {
        if (depth == M) {   // depth = M인 경우(수열 4개를 다 조회하면), 길이가 M인 수열 출력
            for (int i = 0; i < M; i++)
                bw.write(arr[i] + " ");

            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, bw);    // 사용하지 않은 숫자는 true로 바꿔주며 arr에 담아두고 backTracking 진행
                checked[i] = false;                   // 사용이 끝났다면 false로 전환
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 문제 : (1 ~ N)에 대해 중복 없이 개수가 M인 수열 출력

        // 문제 풀이 : 백트래킹 알고리즘 사용
        arr = new int[M];
        checked = new boolean[N+1];

        backTracking(0, bw);

        br.close();
        bw.close();
    }
}