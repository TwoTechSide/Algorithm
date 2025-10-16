import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[][] charCnts = new int[str.length()+1][26];

        for (int i = 1; i <= str.length(); i++) {
            charCnts[i][str.charAt(i-1) - 'a']++;
            for (int j = 0; j < 26; j++) {
                charCnts[i][j] += charCnts[i-1][j];
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = st.nextToken().charAt(0) - 'a';
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(charCnts[to+1][c] - charCnts[from][c]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}