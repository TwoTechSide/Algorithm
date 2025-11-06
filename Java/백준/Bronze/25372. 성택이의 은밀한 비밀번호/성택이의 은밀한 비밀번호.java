import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int len = br.readLine().length();
            if (len < 6 || len > 9)
                sb.append("no\n");
            else
                sb.append("yes\n");
        }

        System.out.println(sb);
    }
}
