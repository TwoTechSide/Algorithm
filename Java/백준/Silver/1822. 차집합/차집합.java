import java.io.*;
import java.security.KeyStore;
import java.util.*;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nA = readInt(), nB = readInt();

        TreeMap<Integer, Boolean> map = new TreeMap<>();

        for (int i = 0; i < nA; i++)
            map.put(readInt(), true);

        for (int i = 0; i < nB; i++)
            map.remove(readInt());

        List<Integer> keyList = new ArrayList<>(map.keySet());

        if (keyList.isEmpty()) {
            System.out.println("0");
            return;
        }

        bw.write(keyList.size() + "\n");

        StringBuilder sb = new StringBuilder();
        for (Integer key : keyList)
            sb.append(key).append(" ");

        bw.write(sb.toString());

        bw.flush();

        br.close();
        bw.close();
    }
}
