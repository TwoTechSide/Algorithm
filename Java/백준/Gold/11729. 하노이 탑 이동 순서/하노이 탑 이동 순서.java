import java.io.*;

public class Main {

    static StringBuilder sb;

    public static void towerOfHanoi(int N, int from, int to) {
        if (N > 1) {
            int extraPos = 6-from-to;
            towerOfHanoi(N-1, from, extraPos);
            sb.append(from).append(" ").append(to).append("\n");
            towerOfHanoi(N-1, extraPos, to);
        } else {
            sb.append(from).append(" ").append(to).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 문제 풀이
        // N개의 원판을 총 이동하기 위한 개수 : P(N)와 시작점 f, 도착지 t를 제외한 중간 경로 e에 대해
        // 1. P(N-1)을 f -> e
        // 2. 가장 큰 원판을 f -> t
        // 3. (1.)에 있던 P(N-1)을 e -> t 
        // P(N) = 2 * P(N-1) + 1 이기 때문에 총 이동 횟수는 2^N - 1
        double cnt = Math.pow(2, N) - 1;
        sb.append((int) cnt).append("\n");

        towerOfHanoi(N, 1, 3);

        System.out.println(sb);
    }
}