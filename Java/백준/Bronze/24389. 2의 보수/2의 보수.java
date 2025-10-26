import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        
        String str = Integer.toBinaryString(num ^ (~num + 1));
        
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                System.out.println(i+1);
                break;
            }
        }
    }
}