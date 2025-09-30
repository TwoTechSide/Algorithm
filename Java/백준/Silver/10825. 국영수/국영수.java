import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];

        for (int i = 0; i < N; i++)
            arr[i] = br.readLine().split(" ");

        Arrays.sort(arr, (o1, o2) -> {
            if (!o1[1].equals(o2[1])) return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            else if (!o1[2].equals(o2[2])) return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            else if (!o1[3].equals(o2[3])) return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
            else return o1[0].compareTo(o2[0]);
        });

        for(String[] subArr: arr)
            bw.write(subArr[0] + "\n");

        bw.flush();

        br.close();
        bw.flush();
    }
}