import java.io.*;
import java.util.*;

public class Main {

    public static int r;
    public static int c;

    public static double Z_Function(double n) {

        if (n == 0)
            return 0;

        int wh = (int) Math.pow(2, n);

        if (r < wh/2 && c < wh/2) { return Z_Function(n-1); }
        else if (r < wh/2 && c < wh) { c -= wh/2; return (wh*wh)/4 + Z_Function(n-1); }
        else if (r < wh && c < wh/2) { r -= wh/2; return (wh*wh)/4 * 2 + Z_Function(n-1); }
        else { r -= wh/2; c -= wh/2; return (wh*wh)/4 * 3 + Z_Function(n-1); }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println((int) Z_Function(N));
    }
}