import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] chs = new char[0];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (i == 0) {
                chs = str.toCharArray();
                continue;
            }

            for (int j = 0; j < str.length(); j++)
                if (chs[j] != str.charAt(j)) chs[j] = '?';
        }

        System.out.println(String.valueOf(chs));
    }
}