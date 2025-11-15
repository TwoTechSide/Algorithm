import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Serial implements Comparable<Serial> {

	String str;
	int sum;

	public Serial(String str, int sum) {
		this.str = str;
		this.sum = sum;
	}

	@Override
	public int compareTo(Serial o) {

		if (this.str.length() != o.str.length()) {
			return this.str.length() - o.str.length();
		} else if (this.sum != o.sum) {
			return this.sum - o.sum;
		} else {
			return this.str.compareTo(o.str);
		}
	}
}

public class Main {

    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Serial> pq = new PriorityQueue<>();

		while (N-- > 0) {
			String str = br.readLine();
			int sum = 0;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if ('1' <= c && c <= '9')
					sum += c - '0';
			}

			pq.add(new Serial(str, sum));
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			sb.append(pq.poll().str).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
    }
}
