import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine())+"\n");

        br.close();
        bw.close();
    }
}