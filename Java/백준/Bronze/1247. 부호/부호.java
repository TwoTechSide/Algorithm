import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {

            int N = Integer.parseInt(br.readLine());
            BigInteger result = new BigInteger("0");

            for (int j = 0; j < N; j++)
                result = result.add(new BigInteger(br.readLine()));

            if (result.equals(BigInteger.ZERO))
                bw.write("0\n");
            else
                bw.write(result.signum() == 1 ? "+\n" : "-\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}