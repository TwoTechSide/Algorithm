import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0;
        int c;
        while ((c = System.in.read()) != '\n') {
            N = N*10+c-'0';
        }

        for (int i = 1; i <= N; i++)
            bw.write("Case #"+i+": "+reverse()+"\n");

        bw.flush();
        bw.close();
    }

    public static String reverse() throws IOException {

        StringBuilder sb = new StringBuilder();
        int index = 0;

        int c;
        while ((c = System.in.read()) != '\n') {
            if (c == ' ') {
                sb.insert(0, ' ');
                index = 0;
                continue;
            }
            sb.insert(index++, (char) c);
        }

        return sb.toString();
    }
}