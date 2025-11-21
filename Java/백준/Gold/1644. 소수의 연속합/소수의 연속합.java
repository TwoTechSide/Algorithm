import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static boolean isPrime(int num) {
		int i = 2;

		while (i * i <= num) {
			if (num % i == 0)
				return false;
			i++;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[] arr = new int[N+1];
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= N; i++) {
			if (isPrime(i)) {
				primes.add(i);
				arr[i]++;

				int sum = i;
				int prev = primes.size() - 2;

				while (prev >= 0) {
					sum += primes.get(prev--);

					if (sum > N)
						break;

					arr[sum]++;
				}
			}
		}

		System.out.println(arr[N]);
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}