import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        System.out.println(Long.parseLong(strs[0]+strs[1]) + Long.parseLong(strs[2]+strs[3]));
    }
}