import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();

        int c;

        while ((c = System.in.read()) != '\n')
            sb.append((char) (c^32));

        System.out.print(sb);
    }
}