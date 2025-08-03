import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        char[] ps = new char[4];

        for (int i=0; i<4; i++) ps[i] = "()[]".charAt(i);

        while (!(str = br.readLine()).equals(".")) {

            str = str.replaceAll("[^()\\[\\]]", "");

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i);

                for (int j=0; j<ps.length; j++) {
                    if (c == ps[j]) {
                        if (j%2 == 0) stack.push(c);
                        else if (stack.isEmpty() || stack.pop() != ps[j-1]) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }
            }

            if (isValid && stack.empty())
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}