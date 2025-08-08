import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < 4; i++)
            result += Integer.parseInt(st.nextToken());

        result = Math.max(0, 4 * Integer.parseInt(st.nextToken()) - result);
        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}