import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            if (Math.abs(result - 100) < Math.abs(result + num - 100)) break;
            result += num;
        }

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}