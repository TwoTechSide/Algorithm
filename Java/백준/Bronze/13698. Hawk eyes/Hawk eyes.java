import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 3);
		map.put('B', 5);
		map.put('C', 9);
		map.put('D', 6);
		map.put('E', 10);
		map.put('F', 12);

		int small = 1;
		int big = 8;
		int c;

		while ((c = System.in.read()) != '\n') {
			int d = map.get((char) c);
			if ((small & d) > 0) small ^= d;
			if ((big & d) > 0) big ^= d;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(small).length()).append("\n").append(Integer.toBinaryString(big).length()).append("\n");
		System.out.println(sb);
	}
}