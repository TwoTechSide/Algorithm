import java.io.*;
import java.util.StringTokenizer;

public class Main {

    final static int R = 0;
    final static int G = 1;
    final static int B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 문제 풀이
        // i=1 번째 줄 부터 RGB가 다른 이전 줄과의 최솟값을 누적합으로 나타낸 뒤, 최종 결과물의 최솟값 출력

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int priceR = Integer.parseInt(st.nextToken());
            int priceG = Integer.parseInt(st.nextToken());
            int priceB = Integer.parseInt(st.nextToken());

            if (i == 0) {
                list[0][R] = priceR;
                list[0][G] = priceG;
                list[0][B] = priceB;
            } else {
                list[i][R] = priceR + Math.min(list[i-1][G], list[i-1][B]);
                list[i][G] = priceG + Math.min(list[i-1][R], list[i-1][B]);
                list[i][B] = priceB + Math.min(list[i-1][R], list[i-1][G]);
            }
        }

        int resultR = list[N-1][R];
        int resultG = list[N-1][G];
        int resultB = list[N-1][B];

        if (resultR > resultG || resultR > resultB) {
            bw.write(Math.min(resultG, resultB)+"\n");
        } else
            bw.write(resultR+"\n");

        bw.flush();

        br.close();
        bw.close();
    }
}