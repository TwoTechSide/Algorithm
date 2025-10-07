import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int result = 0;

        while (n1 < n2) {
            result++;

            if ((n2 & 1) != 1)
                n2 /= 2;
            else if (n2 % 10 == 1)
                n2 /= 10;
            else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println((n1 == n2) ? ++result : -1);
    }
}