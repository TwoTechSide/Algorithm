import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long input = Long.parseLong(br.readLine());
        long output = 0L;

        while (input > 0) {
            long num = 1L;
            long cnt = 0;

            while (input >= (num << 1)) {
                num <<= 1;
                cnt++;
            }

            input -= num;

            long pow3 = 1;
            while (cnt-- > 0) pow3 = (pow3 << 1) + pow3;

            output += pow3;
        }

        System.out.println(output);
    }
}