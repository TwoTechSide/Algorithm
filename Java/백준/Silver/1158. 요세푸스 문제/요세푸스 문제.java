import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int pos = 0;

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        bw.write("<");
        while (!list.isEmpty()) {
            pos = (pos + K-1) % list.size();
            bw.write(String.valueOf(list.remove(pos)));
            if (!list.isEmpty()) bw.write(", ");
        }
        bw.write(">");

        bw.flush();

        br.close();
        bw.close();
    }
}