import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문제 풀이
        // 삼각형이 바깥쪽으로 돌아가며 그려지므로 n = 6부터 삼각형의 긴 변의 길이 k는 (n-1) + (n-5)의 형태를 띔

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int num = Integer.parseInt(br.readLine());
            long[] k = new long[Math.max(6, num+1)];

            k[1] = 1;
            k[2] = 1;
            k[3] = 1;
            k[4] = 2;
            k[5] = 2;

            for (int j=6; j<=num; j++)
                k[j] = k[j-1] + k[j-5];

            bw.write(k[num]+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}