import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static int readInt() throws IOException {
        int c = System.in.read();
        boolean negative = false;

        if (c == '-') {
            negative = true;
            c = System.in.read();
        }

        int n = c & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return negative ? -n : n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt(), M = readInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = readInt();

        Arrays.sort(arr);

        int left = 0, right = 1;
        int result = Integer.MAX_VALUE;
        int diff;

        while (right < N) {
            diff = arr[right] - arr[left];

            if (diff < M) {
                right++;
                continue;
            }
            
            result = Math.min(result, diff);
            left++;

            if (result == M)
                break;
        }

        System.out.println(result);
    }
}