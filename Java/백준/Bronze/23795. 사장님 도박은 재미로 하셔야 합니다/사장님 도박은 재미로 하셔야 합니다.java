import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		int result = 0;
		int n;

		while ((n = readInt()) != -1) result += n;
		System.out.println(result);
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