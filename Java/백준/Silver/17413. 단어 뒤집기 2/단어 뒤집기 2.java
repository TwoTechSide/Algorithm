import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Deque<Character> deque = new ArrayDeque<>();
        boolean isReverse = true;

        int c;
        while ((c = System.in.read()) != '\n') {

            if (!isReverse) {
                deque.push((char) c);

                if (c == '>') {
                    drainQ(deque);
                    isReverse = true;
                }

            } else {
                if (c == ' ') {
                    drainS(deque);
                    sb.append(" ");
                    continue;
                }

                if (c == '<') {
                    drainS(deque);
                    isReverse = false;
                }
                deque.push((char) c);
            }
        }

        if (isReverse) {
            drainS(deque);
        } else {
            drainQ(deque);
        }

        System.out.println(sb.toString());
    }

    public static void drainQ(Deque<Character> deque) {
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
    }

    public static void drainS(Deque<Character> deque) {
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
    }
}
