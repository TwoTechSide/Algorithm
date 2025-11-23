import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static int size;
	public static boolean[][] diagonal;
	public static List<int[]> emptyBlackList = new ArrayList<>();
	public static List<int[]> emptyWhiteList = new ArrayList<>();
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		size = readInt();
		diagonal = new boolean[size*2][2];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (readInt() == 1) {
					// 검은 영역, 흰 영역을 별개로 구분
					if (((i + j) & 1) == 0) emptyBlackList.add(new int[] {i, j});
					else emptyWhiteList.add(new int[] {i, j});
				}
			}
		}

		backTracking(emptyBlackList, 0, 0);
		int blackCount = result;

		// diagonal, result 초기화
		diagonal = new boolean[size*2][2];
		result = 0;

		backTracking(emptyWhiteList, 0, 0);
		int whiteCount = result;

		System.out.println(blackCount + whiteCount);
	}

	public static void backTracking(List<int[]> list, int depth, int count) {

		result = Math.max(result, count);

		for (int i = depth; i < list.size(); i++) {
			int[] cur = list.get(i);
			int y = cur[0];
			int x = cur[1];

			// 해당 대각선에 놓을 수 있는지 없는지만 판단
			if (diagonal[y+x][0] || diagonal[size+y-x][1])
				continue;

			diagonal[y+x][0] = true;
			diagonal[size+y-x][1] = true;
			backTracking(list, i+1, count+1);
			diagonal[y+x][0] = false;
			diagonal[size+y-x][1] = false;
		}
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}