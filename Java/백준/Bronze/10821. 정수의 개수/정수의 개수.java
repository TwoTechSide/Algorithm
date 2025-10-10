import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int c;
        int result = 1;

        while ((c = System.in.read()) != '\n') {
            if (c == ',') result++;
        }

        System.out.println(result);
    }
}