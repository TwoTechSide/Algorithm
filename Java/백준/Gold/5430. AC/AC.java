import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            long n = Long.parseLong(br.readLine());
            String arrStr = br.readLine();

            // 'D'의 개수 > n 이면 error 출력
            long dCnt = p.chars().filter(c -> c == (int) 'D').count();
            if (dCnt > 0 && dCnt > n) {
                bw.write("error\n");
                continue;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            insertValues(arrStr, deque);

            boolean reverse = false;

            // p 함수 실행
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                    continue;
                }

                if (reverse) deque.removeLast();
                else deque.removeFirst();
            }

            // 남아있는 deque 출력
            bw.write("[");
            while (!deque.isEmpty()) {
                if (!reverse) bw.write(String.valueOf(deque.removeFirst()));
                else bw.write(String.valueOf(deque.removeLast()));

                if (!deque.isEmpty()) bw.write(",");
            }
            bw.write("]\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static void insertValues(String str, Deque<Integer> deque) {
        str = str.substring(1, str.length() - 1);

        if (!str.isEmpty())
            Arrays.stream(str.split(",")).forEach(e -> deque.addLast(Integer.parseInt(e)));
    }
}