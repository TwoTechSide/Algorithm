import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();

			while (N-- > 0) {
				String[] input = br.readLine().split(" ");
				String command = input[0];
				int num = Integer.parseInt(input[1]);

				if (command.equals("I"))
					map.merge(num, 1, Integer::sum);

				else if (command.equals("D")) {
					int key;

					if (map.isEmpty())
						continue;

					if (num == -1) {
						key = map.firstKey();
						map.merge(key, -1, Integer::sum);

					} else {
						key = map.lastKey();
						map.merge(key, -1, Integer::sum);
					}

					if (map.get(key) == 0)
						map.remove(key);
				}
			}

			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}

		System.out.println(sb);
	}
}