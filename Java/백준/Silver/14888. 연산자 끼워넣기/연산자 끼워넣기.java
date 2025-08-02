import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static int[] arr;
    static int[] arithmeticArr;
    static int[] arithmeticCnt = new int[4];

    public static void backTracking(int depth) {
        // 사칙 연산을 모두 배치한 경우 순서대로 계산한 뒤 최댓값 최솟값 갱신
        if (depth == arithmeticArr.length) {
            int totalNum = arr[0];
            for (int i = 0; i < arithmeticArr.length; i++) {
                int arithmetic = arithmeticArr[i];

                switch(arithmetic) {
                    case 0: totalNum += arr[i+1]; break;
                    case 1: totalNum -= arr[i+1]; break;
                    case 2: totalNum *= arr[i+1]; break;
                    case 3: totalNum /= arr[i+1]; break;
                }
            }

            maxValue = Math.max(maxValue, totalNum);
            minValue = Math.min(minValue, totalNum);
        }

        // 사칙연산 +, -, *, /를 각각 0 ~ 3으로 arithmeticArr에 할당하며 백트래킹
        for (int i = 0; i < arithmeticCnt.length; i++) {
            if (arithmeticCnt[i] > 0) {
                arithmeticCnt[i]--;
                arithmeticArr[depth] = i;
                backTracking(depth + 1);
                arithmeticCnt[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // arr : 숫자 배열
        // arithmeticArr : 사칙연산 배열
        // arithmeticCnt : 사칙연산 개수
        arr = new int[N];
        arithmeticArr = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arithmeticCnt[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        bw.write(maxValue + "\n");
        bw.write(minValue + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}