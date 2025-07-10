import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            
            // 거리가 1인 경우, 1을 출력하고 건너뛰기
            if (distance == 1) {
                bw.write("1\n");
                continue;
            }
            
            int result = 0;
            int extraResult = 0;

            // 최소로 x -> y에 도달하기 위해서는 1, 2, ..., 2, 1 형태로 움직여야 함
            while (distance > 2*result) {
                distance -= ++result*2;
            }

            // 만약 거리가 남은 경우
            // result값 + 1보다 큰 값으로 남은 경우 2번, 아니면 1번 추가 이동
            if (distance > 0)
                extraResult = (distance > result+1) ? 2 : 1;

            bw.write((2*result+extraResult)+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}