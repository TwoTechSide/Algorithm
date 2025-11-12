import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            list.add(str);
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (!str.equals(list.getFirst()))
                result++;

            list.remove(str);
        }

        System.out.println(result);
    }
}
