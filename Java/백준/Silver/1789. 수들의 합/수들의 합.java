import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        int result = 0;

        do {
            result++;
        } while (2 * S >= (long) result * (result + 1));

        bw.write(String.valueOf(result - 1));
        bw.write("\n");
        bw.flush();

        br.close();
        bw.close();
    }
}