import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder str = new StringBuilder(br.readLine());

        String[] arr = new String[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.toString();
            str.deleteCharAt(0);
        }

        Arrays.sort(arr);

        for (String s: arr)
            bw.write(s+"\n");

        bw.flush();

        br.close();
        bw.close();
    }
}