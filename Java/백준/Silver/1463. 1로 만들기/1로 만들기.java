import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int[] cnt = new int[Math.max(4, X+1)];

        cnt[1] = 0;
        cnt[2] = 1;
        cnt[3] = 1;

        // 문제 풀이
        // X 까지의 연산 횟수 cnt(X)에 대해, cnt(X)-1 = cnt(X-1), cnt(X/2), cnt(X/3)중 최댓값을 가짐
        for (int i = 4; i <= X; i++) {
            cnt[i] = cnt[i-1] + 1;

            if (i%2 == 0)
                cnt[i] = Math.min(cnt[i], cnt[i/2]+1);

            if (i%3 == 0)
                cnt[i] = Math.min(cnt[i], cnt[i/3]+1);
        }

        bw.write(cnt[X]+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}