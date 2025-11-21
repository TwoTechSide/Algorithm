import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static boolean isPrime(int num) {

		int i = 2;

		while (i * i <= num) {
			if (num % i == 0) return false;
			i++;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {

		int N = readInt();

		int[] primes = new int[N+1];
		int index = 0;

		for (int i = 2; i <= N; i++) {
			if (isPrime(i)) {
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