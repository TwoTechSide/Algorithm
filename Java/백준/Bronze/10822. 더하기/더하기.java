import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Deque<Integer> nums = new ArrayDeque<>();
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != ',') nums.add(c - '0');
			else result += getValue(nums);
		}

		result += getValue(nums);
		System.out.println(result);
	}

	public static int getValue(Deque<Integer> nums) {
		int tmp = 0;
		while (!nums.isEmpty()) tmp = (tmp << 3) + (tmp << 1) + nums.poll();
		return tmp;
	}
}