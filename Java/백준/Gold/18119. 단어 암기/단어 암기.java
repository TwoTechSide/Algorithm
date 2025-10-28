import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 18119번 문제
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] words = new int[N];
        int memorize = -1; // 모든 비트 미리 1 대입

        int c;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) words[i] |= (1 << (str.charAt(j) - 'a'));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            char ch = st.nextToken().charAt(0);

            if (command == '1') {
                c = 1 << (ch - 'a');
                if ((c & 1065233) == 0) memorize &= ~c;
            }
            else memorize |= 1 << (ch - 'a');

            int cnt = 0;

            for (int j = 0; j < N; j++)
                if ((words[j] & memorize) == words[j]) cnt++;

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}