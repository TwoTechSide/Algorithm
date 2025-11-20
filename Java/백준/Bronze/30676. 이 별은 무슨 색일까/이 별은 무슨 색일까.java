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

		map.put(620, "Red");
		map.put(590, "Orange");
		map.put(570, "Yellow");
		map.put(495, "Green");
		map.put(450, "Blue");
		map.put(425, "Indigo");
		map.put(380, "Violet");

		int num = readInt();
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			if (num >= entry.getKey()) {
				System.out.println(entry.getValue());
				return;
			}
		}
	}
}