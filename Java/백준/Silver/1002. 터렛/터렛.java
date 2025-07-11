import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 조규현과 백승환 사이의 거리 계산
            int distanceSquare = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

            /* 조규현의 원을 c1, 백승환의 원을 c2라고 했을 때 */

            // 1. c1과 c2가 완전히 겹치는 경우 "-1" 출력
            if ((x1 == x2) && (y1 == y2) && (r1 == r2))
                bw.write("-1\n");
            // 2. 한 점에서 만나는 경우
            else if (distanceSquare == (r2-r1)*(r2-r1) || (distanceSquare == (r1+r2)*(r1+r2)))
                bw.write("1\n");
            // 3. 작은 원이 큰 원 안에 들어가는 경우 또는 겹쳐지는 공간이 없는 경우
            else if (distanceSquare < (r2-r1)*(r2-r1) || distanceSquare > (r1+r2)*(r1+r2))
                bw.write("0\n");
            // 4. 나머지 경우
            else
                bw.write("2\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}