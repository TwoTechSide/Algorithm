import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static List<Integer> list = new ArrayList<>(9);
    public static int sum = -100;

    public static void remove() {
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) + list.get(j) == sum) {
                    list.remove(i);
                    list.remove(j);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }

        remove();

        list.sort(Comparator.comparingInt(o -> o));
        for (int n: list) bw.write(n+"\n");

        bw.flush();

        br.close();
        bw.close();
    }
}