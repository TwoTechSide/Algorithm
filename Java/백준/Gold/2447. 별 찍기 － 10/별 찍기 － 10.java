import java.io.*;

public class Main {

    static char[][] arr;

    public static void drawSquare(int x, int y, int N, boolean blank) {

        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N/3;
        int count = 0;

        for (int i = x; i < x + N; i+= size) {
            for (int j = y; j < y + N; j+= size) {
                count++;
                if (count == 5) {
                    drawSquare(i, j, size, true);
                } else {
                    drawSquare(i, j, size, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        drawSquare(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}