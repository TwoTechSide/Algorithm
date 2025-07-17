import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 문제 풀이
        // 계단 오르기 문제(2579)와 유사한 문제이므로 비슷하게 풀이
        // 단, 2칸 건너뛰기도 가능하므로 누적합을 3개로 계산 (3칸부터는 중간 값을 누적하고 다시 건너뛰는게 가능하므로 생략)

        int[] list = new int[n];
        int[][] sumList = new int[n][3];

        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumList[i][0] = list[0];
                sumList[i][1] = 0;
                sumList[i][2] = 0;
            } else if (i == 1) {
                sumList[i][0] = list[0] + list[1];
                sumList[i][1] = list[i];
                sumList[i][2] = 0;
            } else {
                sumList[i][0] = Math.max(sumList[i-1][1], sumList[i-1][2]) + list[i];
                sumList[i][1] = Math.max(Math.max(sumList[i-2][0], sumList[i-2][1]), sumList[i-2][2]) + list[i];
                sumList[i][2] = list[i];
                if (i > 2)
                    sumList[i][2] += Math.max(Math.max(sumList[i-3][0], sumList[i-3][1]), sumList[i-3][2]);
            }

//            bw.write("sumList = " + sumList[i][0] + ", " + sumList[i][1] + ", " + sumList[i][2] + "\n");
        }

        if (n == 1)
            // n = 1인 경우 첫 번째 값 입력
            bw.write(list[0] + "\n");
        else {
            // 계단 오르기와 다르게 n-2에서도 최댓값이 나올 수 있으므로 4개의 값 비교
            bw.write(Math.max(Math.max(sumList[n-1][0], sumList[n-1][1]), Math.max(sumList[n-2][0], sumList[n-2][1]))+"\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}