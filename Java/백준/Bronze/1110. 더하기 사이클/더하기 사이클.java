import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int tmp = N;

        int result = 0;

        do {
            int num1 = tmp/10;
            int num2 = tmp%10;
            tmp = (num2 * 10) + ((num1 + num2) % 10);
            result++;
        } while (tmp != N);

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}