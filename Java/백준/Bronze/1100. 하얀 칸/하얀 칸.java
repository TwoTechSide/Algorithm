import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;

        for (int i = 0; i < 64; i++) {
            int c = System.in.read();
            if (c == '\n') c = System.in.read();

            if ((c == 'F') && ((i + (i / 8)) & 1) == 0) result++;
        }

        System.out.println(result);
    }
}