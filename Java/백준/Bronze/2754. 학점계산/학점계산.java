import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        double num = 'E' - System.in.read();
        int c = System.in.read();
        if (c == '+') num += 0.3;
        else if (c == '-') num -= 0.3;
        System.out.println(Math.max(0.0, num));
    }
}