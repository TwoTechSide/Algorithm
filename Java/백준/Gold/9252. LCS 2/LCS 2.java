import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] arr = br.readLine().toCharArray();

		String str = br.readLine();
		int[][] dp = new int[arr.length + 1][str.length() + 1];

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (str.charAt(j - 1) == arr[i - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		// 최장 길이
		bw.write(dp[arr.length][str.length()] + "\n");

		StringBuilder sb = new StringBuilder();
		int n1 = arr.length;
		int n2 = str.length();

		while (n1 > 0 && n2 > 0) {
			if (dp[n1-1][n2] == dp[n1][n2]) n1--;
			else if (dp[n1][n2-1] == dp[n1][n2]) n2--;
			else {
				sb.insert(0, arr[n1-1]);
				n1--;
				n2--;
			}
		}

		// 공통 수열
		bw.write(sb.toString());

		bw.flush();

		br.close();
		bw.close();
	}
}