import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static final Map<Integer, String> map = new LinkedHashMap<>();

	public static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws IOException {
		char[] smupc = "WelcomeToSMUPC".toCharArray();
		System.out.println(smupc[(readInt()-1) % smupc.length]);
	}
}