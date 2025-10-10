import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static final Map<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int N = 0;
        int c;
        while ((c = System.in.read()) != '\n') {
            N = N*10 + c-'0';
        }

        for (int i = 0; i < N; i++)
            read();

        map.entrySet().stream().forEach(entry -> {
            try {
                bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
        bw.close();
    }

    public static void read() throws IOException {
        int c;
        boolean flag = false;

        StringBuilder sb = new StringBuilder();

        while ((c = System.in.read()) != '\n') {
            if (flag) {
                sb.append((char) c);
                continue;
            }

            if (c == '.')
                flag = true;
        }

        String str = sb.toString();
        int cnt = map.getOrDefault(str, 0) + 1;
        map.put(str, cnt);
    }
}