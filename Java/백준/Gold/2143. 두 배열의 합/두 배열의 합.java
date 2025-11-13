import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static int readInt() throws IOException {
        int c = System.in.read();
        boolean negative = false;

        if (c == '-') {
            negative = true;
            c = System.in.read();
        }

        int n = c & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return negative ? -n : n;
    }

    public static void main(String[] args) throws IOException {

        int T = readInt();

        int aLen = readInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < aLen; i++) {
            int readNum = readInt();

            deque.addFirst(0);
            int dequeSize = deque.size();

            for (int j = 0; j < dequeSize; j++) {
                int curNum = deque.removeFirst() + readNum;

                map.merge(curNum, 1, Integer::sum);
                deque.addLast(curNum);
            }
        }

        deque.clear();

        int bLen = readInt();
        long result = 0;

        for (int i = 0; i < bLen; i++) {
            int readNum = readInt();

            deque.addLast(0);
            int dequeSize = deque.size();

            for (int j = 0; j < dequeSize; j++) {
                int curNum = deque.removeFirst() + readNum;

                result += map.getOrDefault(T - curNum, 0);
                deque.addLast(curNum);
            }
        }

        System.out.println(result);
    }
}
