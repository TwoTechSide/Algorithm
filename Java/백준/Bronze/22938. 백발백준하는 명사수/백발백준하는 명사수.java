import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static int readInt() throws IOException {
		int n, c = System.in.read();
		boolean negative = (c == '-');

		if (negative) c = System.in.read();
		n = c & 15;

		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return negative ? -n : n;
	}
	public static void main(String[] args) throws IOException {

		long x1 = readInt(), y1 = readInt(), r1 = readInt();
		long x2 = readInt(), y2 = readInt(), r2 = readInt();

		long distance = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
		long r = r1 + r2;

		System.out.println(distance >= r*r ? "NO" : "YES");
	}
}