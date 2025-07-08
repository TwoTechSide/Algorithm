import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);

        String numStr = br.readLine();

        for (int i = 0; i < numStr.length(); i++) {
            numbers[numStr.charAt(i) - '0']++;
        }

        int result = 0;
        for (int i = 0; i < 9; i++) {

            if (i == 6) {
                numbers[6] += numbers[9];
                numbers[6] = (numbers[6] / 2) + (numbers[6] % 2);
            }

            if (numbers[i] > result)
                result = numbers[i];
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}