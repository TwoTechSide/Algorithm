import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] fibonacci = new int[46];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for (int i = 2; i < 46; i++)
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        
        int n = Integer.parseInt(br.readLine());
        
        bw.write(fibonacci[n] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}