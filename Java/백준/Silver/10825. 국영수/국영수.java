import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

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