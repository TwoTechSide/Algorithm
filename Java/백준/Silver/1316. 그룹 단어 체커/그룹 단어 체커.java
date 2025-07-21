import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i<N; i++) {
            String str1 = br.readLine();
            String str2 = str1;

            while(!str2.isEmpty()) {
                String firstStr = String.valueOf(str2.charAt(0));
                str2 = str2.replaceAll(firstStr, "");
                if (str1.indexOf(str2) != (str1.length()-str2.length())) break;
            }
            if (str2.isEmpty())
                result++;
        }

        System.out.println(result);
    }
}