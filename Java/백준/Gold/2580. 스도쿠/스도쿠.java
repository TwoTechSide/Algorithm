import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] sudoku = new int[9][9];
    static int[] zeroPosArr = new int[9*9];
    static int maxDepth = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean isPrinted = false;

    public static boolean isAvailableSudoku(int pos, int num) {
        int x = pos/9;
        int y = pos%9;

        // 만약 가로, 세로, 사각형 안에 같은 수가 있는 경우 false 반환
        // 모든 조건을 통과하면 true 반환
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == num || sudoku[i][y] == num || sudoku[(x/3)*3 + i/3][(y/3)*3 + i%3] == num)
                return false;
        }

        return true;
    }

    public static void backTracking(int depth) {

        // 만약 스도쿠의 모든 자리를 채웠을 경우 스도쿠를 출력하고 isPrinted = true 대입
        if (depth == maxDepth) {
            for (int[] ints : sudoku) {
                for (int i = 0; i < sudoku.length; i++) {
                    sb.append(ints[i]).append(" ");
                }
                sb.append("\n");
            }
            isPrinted = true;
            return;
        }

        // 출력이 된 경우 return 으로 종료
        if (isPrinted)
            return;

        int pos = zeroPosArr[depth];

        for (int i = 1; i <= 9; i++) {
            if (isAvailableSudoku(pos, i)) {
                sudoku[pos/9][pos%9] = i;
                backTracking(depth+1);
                sudoku[pos/9][pos%9] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int[] row : sudoku) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < sudoku.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sudoku.length; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                // 0이 들어갈 때에는 배열에 해당 위치 저장
                if (sudoku[i][j] == 0) {
                    zeroPosArr[maxDepth] = i*9 + j;
                    maxDepth++;
                }
            }
        }

        backTracking(0);

        System.out.println(sb.toString());
        br.close();
    }
}