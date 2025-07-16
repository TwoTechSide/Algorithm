import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N];
        int[][] sumStair = new int[N][2];

        // stair[i]에 각각의 값 입력
        for (int i=0; i<N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N; i++) {
            if (i == 0) {
                sumStair[i][0] = stair[i];
                sumStair[i][1] = stair[i];
            } else if (i == 1) {
                sumStair[i][0] = stair[i-1] + stair[i];
                sumStair[i][1] = stair[i];
            } else {
                // sumStair[i][0] : 이전에 2칸을 뛴 자리 + 1칸
                sumStair[i][0] = sumStair[i-1][1] + stair[i];
                // sumStair[i][0] : 이전에 1칸 또는 2칸을 뛴 자리 + 2칸
                sumStair[i][1] = Math.max(sumStair[i-2][0], sumStair[i-2][1]) + stair[i];
            }
        }

        bw.write(Math.max(sumStair[N-1][0], sumStair[N-1][1])+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}