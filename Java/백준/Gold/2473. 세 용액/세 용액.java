import java.io.*;
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
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return negative ? -n : n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = readInt();
        Arrays.sort(arr);

        int lastPos1 = 0, lastPos2 = 0, lastPos3 = 0;
        long lastSum = Long.MAX_VALUE;

        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;

            while (left < right) {

                // 3개 합 비교
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < lastSum) {
                    lastSum = Math.abs(sum);
                    lastPos1 = i;
                    lastPos2 = left;
                    lastPos3 = right;
                }

                // 투 포인터
                if (sum < 0) left++;
                else right--;
            }
        }

        System.out.println(arr[lastPos1] + " " + arr[lastPos2] + " " + arr[lastPos3]);
    }
}
