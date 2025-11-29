import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine().substring(0, 5);

		int N = Integer.parseInt(br.readLine());

		int result = 0;
		while (N-- > 0)
			if (br.readLine().substring(0, 5).equals(code)) result++;

		System.out.println(result);
	}
}