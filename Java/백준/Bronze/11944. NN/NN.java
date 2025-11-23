import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		char[] chars = String.valueOf(N).toCharArray();
		int maxLength = Math.min(chars.length * N, M);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxLength; i++) sb.append(chars[i % chars.length]);
		System.out.println(sb);
	}

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}