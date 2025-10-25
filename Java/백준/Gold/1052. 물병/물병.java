import java.io.IOException;

public class Main {
    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();

        StringBuilder binaryStringBuilder = new StringBuilder(Integer.toBinaryString(N));

        while (K > 1) {
            char c = binaryStringBuilder.charAt(0);

            if (c == '1')
                K--;

            binaryStringBuilder.deleteCharAt(0);

            if (binaryStringBuilder.length() == 0)
                break;
        }

        String checkOneCnt = binaryStringBuilder.toString();
        int cnt = 0;

        for (int i = 0; i < checkOneCnt.length(); i++)
            cnt += checkOneCnt.charAt(i) - '0';

        if (cnt > 1 && binaryStringBuilder.length() > 0) {
            int remainNum = Integer.parseInt(binaryStringBuilder.toString(), 2);
            int result = ((1 << Integer.toBinaryString(remainNum).length()) - 1) ^ remainNum;

            System.out.println(result+1);
            return;
        }

        System.out.println(0);
    }
}