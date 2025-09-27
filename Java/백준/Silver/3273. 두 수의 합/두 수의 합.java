import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { arr[i] = Integer.parseInt(st.nextToken()); }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int num = arr[j] + arr[i];

                if (num >= x) {
                    if (num == x) result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}