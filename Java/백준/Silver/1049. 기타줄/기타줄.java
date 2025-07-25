import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackagePrice = Integer.MAX_VALUE;
        int minEachPrice = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPackagePrice = Math.min(minPackagePrice, Integer.parseInt(st.nextToken()));
            minEachPrice = Math.min(minEachPrice, Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        if (minPackagePrice < minEachPrice * 6) {
            result += (N / 6) * minPackagePrice;
            result += Math.min((N % 6) * minEachPrice, minPackagePrice);
        } else {
            result += minEachPrice * N;
        }

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}