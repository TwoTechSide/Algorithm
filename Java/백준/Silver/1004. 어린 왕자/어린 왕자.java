import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int[] end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            int N = Integer.parseInt(br.readLine());
            int result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int[] circle = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

                result += (in_circle(circle, start) ^ in_circle(circle, end)) ? 1 : 0;
            }

            bw.write(result + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static boolean in_circle(int[] circle, int[] dot) {
        int dx = circle[0] - dot[0];
        int dy = circle[1] - dot[1];
        int d = circle[2] * circle[2];

        return (dx*dx + dy*dy) < d;
    }
}