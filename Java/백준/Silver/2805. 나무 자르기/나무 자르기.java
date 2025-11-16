import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static int N;
	public static boolean[][] paper;
	public static int white = 0;
	public static int blue = 0;

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		PriorityQueue<Integer> trees = new PriorityQueue<>(Collections.reverseOrder());
		trees.add(0);

		for (int i = 0; i < N; i++)
			trees.add(readInt());


		long treeCnt = 1;
		long curTreeHeight = trees.poll();
		long sum = 0;

		while (true) {
			long nextTreeHeight = trees.poll();
			long need = M - sum;
			long diff = curTreeHeight - nextTreeHeight;

			// 다음 나무의 크기까지 잘라냈을 때 조건을 만족하는 경우
			if (treeCnt * diff >= need) {
				System.out.println(curTreeHeight - need / treeCnt - (need % treeCnt == 0 ? 0 : 1));
				return;
			}

			sum += treeCnt * diff;
			curTreeHeight = nextTreeHeight;
			treeCnt++;
		}
    }
}
