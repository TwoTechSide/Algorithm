import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();

		int N = readInt();

		LinkedList<int[]> list = new LinkedList<>();
		int[][] arr = new int[N+1][3];

		for (int i = 1; i <= N; i++) {
			arr[i][0] = readInt();					// 색상
			arr[i][1] = readInt();					// 크기
			list.add(arr[i]);						// 원본 배열 순서
		}

		// 크기순 정렬
		Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

		int lastIndex = 0;
		int sum = 0;
		int[] colorPreSum = new int[N+1];

		for (int i = 1; i <= N; i++) {
			int[] curArr = arr[i];
			int[] prevArr = arr[lastIndex];

			// 같은 색상의 이전 크기 누적합 저장
			while (prevArr[1] < curArr[1]) {
				sum += prevArr[1];
				colorPreSum[prevArr[0]] += prevArr[1];
				prevArr = arr[++lastIndex];
			}

			// 크기 누적합 - 같은 색상의 이전 크기 누적합
			curArr[2] = sum - colorPreSum[curArr[0]];
		}

		for (int[] result: list)
			sb.append(result[2]).append("\n");

		System.out.println(sb);
    }
}
