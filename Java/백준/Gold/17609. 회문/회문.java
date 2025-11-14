import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static int answer(char[] arr, int left, int right, int num) {

		if (num == 2)
			return 2;

		while (left < right) {
			if (arr[left] == arr[right]) {
				left++;
				right--;
				continue;
			}

			return Math.min(answer(arr, left+1, right, num+1), answer(arr, left, right-1, num+1));
		}

		return num;
	}

    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-->0) {
			char[] arr = br.readLine().toCharArray();
			sb.append(answer(arr, 0, arr.length-1, 0)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
    }
}
