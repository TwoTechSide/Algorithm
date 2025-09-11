import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 99;

        if (N < 111) {
            System.out.println(Math.min(result, N));
            return;
        }


        for (int num = 111; num <= N; num++) {

            char[] chars = String.valueOf(num).toCharArray();
            int diff = chars[1] - chars[0];

            boolean flag = true;

            for (int i = 2; i < chars.length; i++) {
                if (chars[i] - chars[i-1] != diff) {
                    flag = false;
                    break;
                }
            }

            result += flag ? 1 : 0;
        }

        System.out.println(result);
    }
}