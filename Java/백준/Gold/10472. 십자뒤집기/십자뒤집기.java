import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 하드코딩
    public static final int[][] cases = new int[][] { {3, 1, 0}, {7, 2, 0}, {6, 4, 0}, {1, 3, 1}, {2, 7, 2}, {4, 6, 4}, {0, 1, 3}, {0, 2, 7}, {0, 4, 6} };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int[] rows = new int[4];
            rows[3] = 0;    // 바뀐 횟수 저장

            for (int i = 0; i < 3; i++) {
                String str = br.readLine();

                for (int j = 0; j < 3; j++) {
                    if (str.charAt(j) == '*')
                        rows[i] |= 1 << j;
                }
            }

            boolean[] visited = new boolean[1 << 9];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(rows);

            while (!queue.isEmpty()) {
                int[] row = queue.poll();

                if (row[0] + row[1] + row[2] == 0) {
                    sb.append(row[3]).append("\n");
                    break;
                }

                // 이미 지나갔던 경우는 continue
                int visitedNum = row[0] + (row[1] << 3) + (row[2] << 6);
                if (visited[visitedNum]) continue;
                visited[visitedNum] = true;

				for (int[] nextCase : cases) {
					int row1 = row[0] ^ nextCase[0];
					int row2 = row[1] ^ nextCase[1];
					int row3 = row[2] ^ nextCase[2];

					queue.add(new int[] {row1, row2, row3, row[3]+1});
				}
            }
        }

        System.out.println(sb);
    }
}