import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dots = new int[N+1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }

        dots[N][0] = dots[0][0];
        dots[N][1] = dots[0][1];

        double result = 0.0;

        for (int i = 2; i <= N; i++) {
            int px1 = dots[i-1][0] - dots[0][0];
            int py1 = dots[i-1][1] - dots[0][1];
            int px2 = dots[i][0] - dots[0][0];
            int py2 = dots[i][1] - dots[0][1];

            result += (double) px1*py2 / 2.0;
            result -= (double) px2*py1 / 2.0;
        }

        System.out.printf("%.1f%n", Math.abs(result));
    }
}