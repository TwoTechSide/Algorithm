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

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = readInt();

		for (int i = 1; i <= N; i++)
			sb.append(" ".repeat(N-i) + "* ".repeat(i)).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}