import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        char lastChar = bomb.charAt(bomb.length()-1);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            stack.push(c);

            if (c == lastChar && stack.size() >= bomb.length()) {

                boolean flag = true;

                for (int j = 0; j < bomb.length(); j++) {

                    if (stack.get(stack.size()-1-j) != bomb.charAt(bomb.length()-1-j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) sb.append(c);

            System.out.println(sb);
        }
    }
}