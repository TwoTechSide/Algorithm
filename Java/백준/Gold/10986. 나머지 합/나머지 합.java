import java.io.IOException;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt(), M = readInt();
        int[] preSum = new int[N+1];
        long[] remain = new long[M];

        for (int i = 0; i < N; i++) {
            preSum[i+1] = (preSum[i] + readInt()) % M;
            remain[preSum[i+1]]++;
        }

        // remain[0 ~ M-1] : 나머지가 index인 값의 개수
        // result = remain[0] -> 0부터 i 까지의 모든 누적합의 나머지가 0인 경우
        long result = remain[0];

        // [ 0~i 누적합의 나머지 ], [ 0~j 누적합의 나머지가 ]가 같으면 (i+1 ~ j)의 누적합은 나머지가 0
        // 따라서 같은 나머지를 가지는 개수 n으로 nC2 조합 연산을 계속 더해주면 됨
        for (int i = 0; i < M; i++)
            result += remain[i] * (remain[i]-1) >> 1;

        System.out.println(result);
    }
}