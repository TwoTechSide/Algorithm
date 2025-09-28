import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int minRank = map.get(1);
            int result = 1;

            for (int j = 2; j <= N; j++) {
                if (map.get(j) < minRank) {
                    minRank = map.get(j);
                    result++;
                }
            }

            bw.write(result+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}