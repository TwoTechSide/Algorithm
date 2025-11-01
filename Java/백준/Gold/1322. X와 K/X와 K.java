import java.io.IOException;

public class Main {

    public static boolean hasNext = true;

    public static Integer read() throws IOException {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == '\n') hasNext = false;
        return n;
    }

    public static void main(String[] args) throws IOException {

        int x = read();
        int y = read();

        long result = 0;
        int bit = 0;

        // 문제 풀이: x가 0인 위치에 대해 y의 2진수를 집어넣은 값을 출력
        while (y > 0) {
            
            while ((x & 1) == 1) {
                x >>= 1;
                bit++;
            }
            
            if ((y & 1) == 1)
                result |= (1L << bit);

            y >>= 1;
            x >>= 1;
            bit++;
        }

        System.out.println(result);
    }
}