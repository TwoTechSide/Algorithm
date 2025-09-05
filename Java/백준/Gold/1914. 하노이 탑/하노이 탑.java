import java.io.*;
import java.math.BigInteger;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void towerOfHanoi(int n, int from, int to) {

        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        int extraPos = 6-from-to;
        towerOfHanoi(n-1, from, extraPos);
        sb.append(from).append(" ").append(to).append("\n");
        towerOfHanoi(n-1, extraPos, to);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 1. 하노이의 탑 이동 순서 n -> 2^n-1
        BigInteger value = BigInteger.ONE.shiftLeft(K).subtract(BigInteger.ONE);
        sb.append(value).append("\n");
        // 2. 재귀 알고리즘 풀이 (K <= 20인 경우에만)
        if (K <= 20) towerOfHanoi(K, 1, 3);
        System.out.println(sb);
    }
}