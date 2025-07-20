import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] isbn = br.readLine().toCharArray();
        int result = 0;
        int index = 0;  // *이 오는 위치

        for (int i = 0; i < isbn.length; i++) {
            int num = isbn[i] - '0';

            if (0 <= num && num < 10)
                result = (result + num * (i%2==0 ? 1 : 3)) % 10;
            else
                index = i;
        }

        if (result == 0)
            bw.write("0\n");
        else if (index % 2 == 0)
            bw.write((10 - result) + "\n");
        else {
            int i = 0;
            while (result % 10 != 0) {
                result += 3;
                i++;
            }
            bw.write(i + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}