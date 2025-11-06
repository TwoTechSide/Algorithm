import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int c;
        boolean reverse = true;

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        while ((c = System.in.read()) != '\n') {

            if (c == '<') {
                drainStack(stack);
                reverse = false;
                queue.offer((char) c);
            } else if (c == '>') {
                queue.offer((char) c);
                reverse = true;
                drainQueue(queue);
            } else if (c == ' ') {
                drainStack(stack);
                drainQueue(queue);
                sb.append(" ");
            } else {
                if (reverse) {
                    stack.push((char) c);
                } else {
                    queue.offer((char) c);
                }
            }
        }

        drainStack(stack);
        drainQueue(queue);

        System.out.println(sb);
    }

    public static void drainStack(Stack<Character> stack) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    public static void drainQueue(Queue<Character> queue) {
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
    }
}
