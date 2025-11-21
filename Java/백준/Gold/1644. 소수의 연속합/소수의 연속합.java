import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		int N = readInt();

		// 아리스토텔레스의 체로 소수 판별 -> 소수가 여러 개 필요한 상황에서는 이 방법이 for문으로 소수 판별하는 것보다 훨씬 더 빠름
		boolean[] isNotPrimes = new boolean[N+1];
		for (int i = 4; i <= N; i += 2) isNotPrimes[i] = true;
		for (int i = 3; i <= N; i += 2) {
			if (isNotPrimes[i]) continue;
			for (long j = (long) i*i; j <= N; j += 2L*i) isNotPrimes[(int) j] = true;
		}

		int[] primes = new int[N+1];
		int index = 0;

		for (int i = 2; i <= N; i++) {
			if (!isNotPrimes[i]) {
				primes[index++] = i;
			}
		}

		// 투 포인터로 풀이
		int left = 0, right = 0;
		int sum = 0;
		int count = 0;

		while (true) {
			if (sum >= N) {
				if (sum == N) count++;
				sum -= primes[left++];
			} else {
				if (right == index) break;
				sum += primes[right++];
			}
		}

		System.out.println(count);
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}