import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문제 풀이
        // N = 1인 경우, [ 1 ]
        // N = 2인 경우, [ 00, 11 ]
        // N = 3인 경우, (N = 1인 경우 + [ 00 ]) + (N = 2인 경우 + [ 1 ])
        // (N - 2)인 경우에 [ 11 ]을 추가하지 않는 이유는 (N - 1)인 경우와 중복이 되기 때문
        // 따라서 피보나치 수열로 풀이하면 된다

        int N = Integer.parseInt(br.readLine());
        int list[] = new int[Math.max(2, N)];

        list[0] = 1;
        list[1] = 2;

        for (int i = 2; i < N; i++) {
            list[i] = (list[i-1]+list[i-2])%15746;
        }

        bw.write(list[N-1]+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}