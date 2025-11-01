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

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[1 << 20];

        while (hasNext) {

            int num = read();
            int a = num >> 5;
            int b = num & 31;

            // -> 앞의 5비트는 int 범위, 나머지 비트는 배열에 확인
            // ex) 39의 경우, arr[1]의 7번째 비트를 확인한다는 뜻
            if ((arr[a] & (1 << b)) == 0) {
                arr[a] |= (1 << b);
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}