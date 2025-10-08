import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        while (N > 0) {
            result += N & 1;
            N >>= 1;
        }
        
        System.out.println(result);
    }
}