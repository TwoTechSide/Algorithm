import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        while (sb.length() > 10) {
            bw.write(sb.substring(0, 10)+"\n");
            sb.delete(0, 10);
        }
        bw.write(sb.toString());

        bw.flush();

        br.close();
        bw.close();
    }
}