import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, List<String>> map = new HashMap<>();
            StringTokenizer st;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                String on = st.nextToken();

                List<String> list;

                if (map.containsKey(on)) {
                    list = map.get(on);
                } else {
                    list = new ArrayList<>();
                    map.put(on, list);
                }

                list.add(type);
            }

            int result = 1;

            for (Map.Entry<String, List<String>> entry: map.entrySet())
                result *= entry.getValue().size() + 1;

            sb.append(result-1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}