import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            result += Integer.parseInt(br.readLine());
        }

        result -= (N-1);
        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}