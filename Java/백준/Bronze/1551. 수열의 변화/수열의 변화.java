import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] str = br.readLine().split(",");
		int[] nums = new int[str.length];

		for (int i = 0; i < nums.length; i++)
			nums[i] = Integer.parseInt(str[i]);

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < N-i; j++) {
				nums[j] = nums[j+1] - nums[j];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N-K; i++) {
			if (i != 0)
				sb.append(",");
			sb.append(nums[i]);
		}

		System.out.println(sb);
	}
}