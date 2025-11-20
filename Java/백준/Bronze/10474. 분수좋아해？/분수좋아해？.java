import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A, B;
		while ((A = readInt()) > 0 && (B = readInt()) > 0)
			sb.append(A / B).append(" ").append(A % B).append(" / ").append(B).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}