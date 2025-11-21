import java.io.IOException;

// 12015번: 가장 긴 증가하는 부분 수열 2와 같은 맥락의 풀이
public class Main {

	// 이분 탐색 적용
	public static int findIndex(int[] arr, int left, int right, int num) {

		int r = right;

		int mid = (left + right) / 2;

		while (left < right) {

			if (num < arr[mid]) right = mid;
			else if (num > arr[mid]) left = mid + 1;
			else break;

			mid = (left + right) / 2;
		}

		// 만약 배열에 가지고 있는 모든 값보다 큰 경우 -1 반환
		if (mid == r && arr[mid] < num) return -1;
		return mid;
	}

	public static void main(String[] args) throws IOException {
		int N = readInt();

		int[] arr = new int[N];

		int lastIndex = 0;

		for (int i = 0; i < N; i++) {
			int num = readInt() + 1_000_000_001;
			int index = findIndex(arr, 0, lastIndex, num);

			if (index == -1) arr[lastIndex++] = num;
			else arr[index] = num;
		}

		// 배열에 이미 가장 큰 증가하는 수열이 저장되어 있으므로 길이만 반환하면 됨
		System.out.println(lastIndex);
	}

	public static int readInt() throws IOException {
		int c = System.in.read();
		boolean negative = (c == '-');

		if (negative) c = System.in.read();
		int n = c & 15;

		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return negative ? -n : n;
	}
}