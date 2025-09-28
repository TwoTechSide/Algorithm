import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { arr[i] = Integer.parseInt(st.nextToken()); }

        Arrays.sort(arr);

        int frontPos = 0;
        int backPos = N-1;

        int frontResult = 0;
        int backResult = N-1;

        if (arr[frontPos] > 0) {
            System.out.println(arr[frontPos] + " " + arr[frontPos+1]);
            return;
        }

        if (arr[backPos] < 0) {
            System.out.println(arr[backPos-1] + " " + arr[backPos]);
            return;
        }

        int tmp = Integer.MAX_VALUE;

        while (frontPos < backPos) {

            int mixed = arr[frontPos] + arr[backPos];

            if (mixed == 0) {
                System.out.println(arr[frontPos] + " " + arr[backPos]);
                return;
            }

            if (Math.abs(mixed) < tmp) {
                tmp = Math.abs(mixed);
                frontResult = arr[frontPos];
                backResult = arr[backPos];
            }

            if (mixed > 0) backPos--;
            else frontPos++;
        }

        System.out.println(frontResult + " " + backResult);

        bw.flush();

        br.close();
        bw.close();
    }
}