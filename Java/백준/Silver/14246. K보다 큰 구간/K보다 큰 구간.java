import java.io.*;

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int n = readInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = readInt();
        int k = readInt();

        int right = 0;
        int left = 0;
        long sum = 0;
        long result = 0;

        while (right < n) {
            sum += arr[right];

            while (sum > k) {
                result += n - right;
                sum -= arr[left++];
            }

            right++;
        }

        System.out.println(result);
    }
}
