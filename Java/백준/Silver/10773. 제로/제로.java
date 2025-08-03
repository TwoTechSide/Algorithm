import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) stack.push(num);
            else stack.pop();
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
    }
}