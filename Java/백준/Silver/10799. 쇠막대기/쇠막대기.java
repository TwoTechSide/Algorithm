import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') stack.push(c);
            else {
                stack.pop();

                if (str.charAt(i-1) == '(') result += stack.size();
                else result += 1;
            }


        }

        System.out.println(result);
    }
}