import java.io.*;

public class Main {

    public static final int[] prevList = new int[] {-1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = readInt();

        int[][] arr = new int[N][3];
        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = readInt();
                if (i == 0) {
                    minDp[i][j] = arr[i][j];
                    maxDp[i][j] = arr[i][j];
                }
            }
        }

        for (int y = 1; y < N; y++) {
            for (int x = 0; x < 3; x++) {
                int minNum = Integer.MAX_VALUE;
                int maxNum = Integer.MIN_VALUE;
                int curNum = arr[y][x];

                for(int n: prevList) {
                    int prev = x + n;
                    if (prev == -1 || prev == 3)
                        continue;

                    minNum = Math.min(minNum, minDp[y-1][prev]);
                    maxNum = Math.max(maxNum, maxDp[y-1][prev]);
                }

                minDp[y][x] = minNum + curNum;
                maxDp[y][x] = maxNum + curNum;
            }
        }

        int minResult = Integer.MAX_VALUE;
        int maxResult = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            minResult = Math.min(minResult, minDp[N-1][i]);
            maxResult = Math.max(maxResult, maxDp[N-1][i]);
        }

        bw.write(maxResult + " " + minResult);

        bw.flush();
        bw.close();
    }

    public static int readInt() throws IOException {
        int N = 0, c;
        while ((c = System.in.read()) > 32)
            N = N * 10 + c - '0';
        return N;
    }
}