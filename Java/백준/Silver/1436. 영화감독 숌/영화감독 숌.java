import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int value = 666;
        int cnt = 0;

        while (true) {
            if (Integer.toString(value).contains("666")) {
                cnt++;
                if (cnt == num) break;
            }
            value++;
        }

        System.out.println(value);
    }
}