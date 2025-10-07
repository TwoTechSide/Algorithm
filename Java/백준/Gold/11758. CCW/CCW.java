import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dot0 = new int[2];
        st = new StringTokenizer(br.readLine());
        dot0[0] = Integer.parseInt(st.nextToken());
        dot0[1] = Integer.parseInt(st.nextToken());

        int[] dot1 = new int[2];
        st = new StringTokenizer(br.readLine());
        dot1[0] = Integer.parseInt(st.nextToken()) - dot0[0];
        dot1[1] = Integer.parseInt(st.nextToken()) - dot0[1];

        int[] dot2 = new int[2];
        st = new StringTokenizer(br.readLine());
        dot2[0] = Integer.parseInt(st.nextToken()) - dot0[0];
        dot2[1] = Integer.parseInt(st.nextToken()) - dot0[1];

        // [ dot0 -> dot1 ], [ dot0 -> dot2 ] 외적을 통해 부호로 방향 판단
        int d0 = dot1[0] * dot2[1];
        int d1 = dot1[1] * dot2[0];

        if (d0 - d1 > 0) System.out.println(1);
        else if (d0 - d1 < 0) System.out.println(-1);
        else System.out.println(0);
    }
}