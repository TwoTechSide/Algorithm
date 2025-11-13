import java.io.IOException;
import java.util.*;

public class Main {

    public static int readInt() throws IOException {
        int c = System.in.read();
        boolean negative = false;

        if (c == '-') {
            negative = true;
            c = System.in.read();
        }

        int n = c & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return negative ? -n : n;
    }

    public static void main(String[] args) throws IOException {

        int T = readInt();

        int aLen = readInt();
        int[] aArr = new int[aLen];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < aLen; i++) aArr[i] = readInt();

        // 누적합 aSum -> map 저장
        for (int i = 0; i < aLen; i++) {
            int aSum = 0;

            for (int j = i; j < aLen; j++) {
                aSum += aArr[j];
                map.merge(aSum, 1, Integer::sum);
            }
        }

        int bLen = readInt();
        int[] bArr = new int[bLen];
        long result = 0;

        for (int i = 0; i < bLen; i++) bArr[i] = readInt();

        // 누적합 bSum -> map(T - bSum)의 결과 누적
        for (int i = 0; i < bLen; i++) {
            int bSum = 0;

            for (int j = i; j < bLen; j++) {
                bSum += bArr[j];
                result += map.getOrDefault(T-bSum, 0);
            }
        }

        System.out.println(result);
    }
}
