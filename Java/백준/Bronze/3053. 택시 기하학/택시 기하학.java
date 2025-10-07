import java.io.*;

public class Main {

    public static final double PI = 3.14159265358979;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine());

        bw.write(String.format("%.6f\n", PI * R * R));
        bw.write(String.format("%.6f\n", 2.0 * R * R));

        bw.flush();

        br.close();
        bw.close();
    }
}