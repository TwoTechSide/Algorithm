import java.io.IOException;

public class Main {

	public static long totalBitSum(long num) {
		long result = 0;
		long bit = 1;
		
		// 밑의 while문 코드를 이해할 때, 입력했던 값 num에 대해
		// num 대신 (num + 1)이라고 생각하며 이해 필요
		num++;

		while (bit < num) {
			// bit 위치의 일정한 길이의 주기 합
			result += num / (bit << 1) * bit;

			// 남아있는 부분 확인
			long remain = num % (bit << 1);
			if (remain > bit) result += remain - bit;

			bit <<= 1;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		long A = readLong(), B = readLong();
		System.out.println(totalBitSum(B) - totalBitSum(A-1));
	}

	public static long readLong() throws IOException {
		int c;
		long n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}