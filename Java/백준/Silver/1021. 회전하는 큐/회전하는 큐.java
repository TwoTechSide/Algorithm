import java.io.*;
import java.util.*;

public class Main {

    public static int result = 0;

    public static int[] nextQueue(int[] qArr, int num) {
        if (qArr[0] == num)
            return Arrays.copyOfRange(qArr, 1, qArr.length);

        int index1 = qArr.length;
        int index2 = 0;
        int[] copiedQArr = new int[qArr.length - 1];

        for (int i = 1; i <= (qArr.length+1)/2; i++) {
            index1--;
            index2++;
            if (qArr[index1] == num) {
                for (int j = 0; j < copiedQArr.length; j++) copiedQArr[j] = qArr[(index1 + j + 1) % qArr.length];
                result += i;
                return copiedQArr;
            } else if (qArr[index2] == num) {
                for (int j = 0; j < copiedQArr.length; j++) copiedQArr[j] = qArr[(index2 + j + 1) % qArr.length];
                result += i;
                return copiedQArr;
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 큐 생성, 숫자 대입
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] qArr = new int[N];
        for (int i = 1; i <= N; i++) qArr[i-1] = i;

        // 각 주어진 숫자마자 연산 수행
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            qArr = nextQueue(qArr, Integer.parseInt(st.nextToken()));

        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}