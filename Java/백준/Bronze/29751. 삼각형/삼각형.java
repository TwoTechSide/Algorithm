import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        float W = Float.parseFloat(st.nextToken());
        float H = Float.parseFloat(st.nextToken());

        bw.write(String.format("%.1f", (W*H)/2)+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}