import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = (N / 100) * 100;

        int result = N % F;

        if (result == 0) {
            bw.write("00");
        } else {
            result = F - result;
            if (result < 10) { bw.write("0" + result); }
            else { bw.write(result+"\n"); }
        }

        br.close();
        bw.close();
    }
}