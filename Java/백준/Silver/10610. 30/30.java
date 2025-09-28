import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        Arrays.sort(charArr);

        if (charArr[0] != '0') {
            System.out.println(-1);
            return;
        }
        
        // 문제 풀이
        // 1. 0이 포함되지 않으면 30으로 나눌 수 없음
        // 2. 0 1개를 제외한 나머지 모든 값의 합이 3으로 나눌 수 없으면 마찬가지로 30으로 나눌 수 없음
        // 3. 0 1개를 제외한 나머지 모든 값을 역순으로 정렬하면 30으로 나눌 수 있는 가장 큰 수가 됨
        int sum = 0;
        for (char c: charArr) sum += c-'0';
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) sb.append(charArr[i]);

        System.out.println(sb);
    }
}