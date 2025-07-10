import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean isPrime(int num) {

        if (num%2 == 0) return false;

        for (int i=3; i<=Math.sqrt(num); i+=2) {
            if (num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num;

        while((num = Integer.parseInt(br.readLine())) > 0) {
            int cnt = (num == 1) ? 1 : 0;

            for(int i=num+1; i<2*num; i++)
                if (isPrime(i)) cnt++;

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}