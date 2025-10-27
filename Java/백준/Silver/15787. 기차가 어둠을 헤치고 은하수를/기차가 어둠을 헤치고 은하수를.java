import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final int maxCase = Integer.parseInt("1".repeat(20), 2);

    public static int readInt() throws IOException {
        int c, n=System.in.read() & 15;
        while((c=System.in.read())>32) n=(n<<3)+(n<<1)+(c&15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int N = readInt(), M = readInt();
        int[] train = new int[N+1];

        while (M-- > 0) {
            int command = readInt(), selectTrain = readInt();

            switch (command) {
                case 1: train[selectTrain] |= 1 << (readInt()-1); break;
                case 2: train[selectTrain] &= ~(1 << (readInt()-1)); break;
                case 3: train[selectTrain] = (train[selectTrain] << 1) & maxCase; break;
                case 4: train[selectTrain] = (train[selectTrain] >> 1);
            }
        }

        Set<Integer> trainSet = new HashSet<>();
        for (int i = 1; i <= N; i++) trainSet.add(train[i]);

        System.out.println(trainSet.size());
    }
}