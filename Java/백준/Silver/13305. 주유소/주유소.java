import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] list = new long[N-1][4];     // index, distance, price
        long sumDistance = 0;

        // 인덱스 표시
        for (int i = 0; i < N-1; i++)
            list[i][0] = i;

        // 남은 거리 계산
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            int distance = Integer.parseInt(st.nextToken());
            list[i][1] = distance;
        }

        for (int i = N-2; i >= 0; i--) {
            sumDistance += list[i][1];
            list[i][1] = sumDistance;
        }

        // 각 도시의 주유소 가격 입력, 마지막은 제외
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i == N-1) break;
            list[i][2] = Integer.parseInt(st.nextToken());
        }

        // 주유소 가격의 오름차순으로 정렬
        Arrays.sort(list, Comparator.comparingLong(o -> o[2]));

        // 1. 주유소 가격이 낮은 순으로 조회 시작
        // 2. 남은 거리 x 주유소 가격 합
        // 3. 이전 인덱스인 경우, [ 남은 거리 - 이전의 남은 거리 ] x [ 주유소 가격 ] 누적합 진행
        long preIndex = N;
        long preDistance = 0;
        long result = 0;

        for (int i = 0; i < N-1; i++) {
            long index = list[i][0];

            if (preIndex > index) {
                long distance = list[i][1];
                long price = list[i][2];

                result += price * (distance - preDistance);
                preDistance = distance;
                preIndex = index;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}