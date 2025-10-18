import java.io.IOException;

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

        int N = readInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = readInt();

        int left = 0;
        int right = N - 1;

        if (arr[left] >= 0) {
            System.out.println(arr[left] + " " + arr[left+1]);
            return;
        }

        if (arr[right] <= 0) {
            System.out.println(arr[right-1] + " " + arr[right]);
            return;
        }

        int acid = 0;
        int alkaline = 0;
        int minDiff = Integer.MAX_VALUE;

        while (left < right) {
            int curDiff = arr[right] + arr[left];

            if (Math.abs(curDiff) < minDiff) {
                minDiff = Math.abs(curDiff);
                acid = arr[left];
                alkaline = arr[right];

                if (minDiff == 0)
                    break;
            }

            if (curDiff > 0)
                right--;
            else
                left++;
        }

        System.out.println(acid + " " + alkaline);
    }
}