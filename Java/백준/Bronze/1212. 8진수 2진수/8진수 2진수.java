import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int c;
        while ((c = System.in.read()) > 32) {
            StringBuilder sub = new StringBuilder();
            c &= 7;
            while (c > 0) {
                sub.insert(0, c & 1);
                c >>= 1;
            }
            while (sub.length() < 3) {
                sub.insert(0, 0);
            }
            sb.append(sub);
        }

        if (sb.toString().equals("000")) {
            System.out.println(0);
            return;
        }

        sb.delete(0, sb.indexOf("1"));
        System.out.println(sb);
    }
}