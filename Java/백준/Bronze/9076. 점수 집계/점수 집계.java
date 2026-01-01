import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();

		int T = readInt();

		while (T-- > 0) {
			int[] grades = new int[5];

			for (int i = 0; i < grades.length; i++) grades[i] = readInt();
			Arrays.sort(grades);

			if (grades[3] - grades[1] >= 4) sb.append("KIN\n");
			else sb.append(grades[1] + grades[2] + grades[3]).append("\n");
		}

		System.out.print(sb);
	}
}