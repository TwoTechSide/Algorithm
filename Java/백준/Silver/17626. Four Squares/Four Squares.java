import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        Arrays.fill(arr, 5);
        arr[1] = 1;

        for (int i = 1; i*i <= N; i++) {
            arr[i*i] = 1;

            if (i*i == N) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j*j <= i/2; j++) {
                if (arr[i] < 3)
                    continue;

                arr[i] = Math.min(arr[i], arr[i-j*j] + arr[j*j]);
            }
        }

        System.out.println(arr[N]);
    }
}