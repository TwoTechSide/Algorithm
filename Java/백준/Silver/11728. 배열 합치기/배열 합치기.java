import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = N + Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = N; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int n: arr)
            bw.write(n+" ");

        bw.flush();

        br.close();
        bw.close();
    }
}