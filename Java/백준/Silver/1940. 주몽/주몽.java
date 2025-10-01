import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(arr);

        int front = 0;
        int back = N-1;
        int result = 0;

        while (front < back) {
            int sum = arr[front] + arr[back];

            if (sum == M) {
                result++;
                back--;
                front++;
            }
            else if (sum > M) back--;
            else front++;
        }

        System.out.println(result);
    }
}