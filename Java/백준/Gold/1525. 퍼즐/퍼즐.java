import java.io.IOException;
import java.util.*;

public class Main {

    public static final int[] POW10 = new int[] {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        int board = 0;
        int zeroPos = 0;

        for (int i = 0; i < 9; i++) {
            int num = readInt();
            board += num * POW10[i];

            if (num == 0)
                zeroPos = i;
        }

        Deque<int[]> deque = new LinkedList<>();
        Set<Integer> isVisited = new HashSet<>();

        deque.add(new int[] {board, zeroPos, 0});

        while(!deque.isEmpty()) {

            int[] arr = deque.poll();
            int curBoard = arr[0];
            int curZeroPos = arr[1];

            if (curBoard == 87654321) {
                System.out.println(arr[2]);
                return;
            }

            if (isVisited.contains(curBoard))
                continue;

            isVisited.add(curBoard);
            int nextZeroPos;

            if (curZeroPos > 2) {
                nextZeroPos = curZeroPos - 3;
                deque.add(new int[] {swapBoard(curBoard, curZeroPos, nextZeroPos), nextZeroPos, arr[2]+1});
            }

            if (curZeroPos < 6) {
                nextZeroPos = curZeroPos + 3;
                deque.add(new int[] {swapBoard(curBoard, curZeroPos, nextZeroPos), nextZeroPos, arr[2]+1});
            }

            if (curZeroPos % 3 != 0) {
                nextZeroPos = curZeroPos - 1;
                deque.add(new int[] {swapBoard(curBoard, curZeroPos, nextZeroPos), nextZeroPos, arr[2]+1});
            }

            if (curZeroPos % 3 != 2) {
                nextZeroPos = curZeroPos + 1;
                deque.add(new int[] {swapBoard(curBoard, curZeroPos, nextZeroPos), nextZeroPos, arr[2]+1});
            }
        }
        
        System.out.println(-1);
    }

    public static int swapBoard(int curBoard, int curZeroPos, int nextZeroPos) {
        int beforeVal = curBoard / POW10[curZeroPos] % 10;
        int afterVal = curBoard / POW10[nextZeroPos] % 10;

        curBoard = curBoard - (beforeVal * POW10[curZeroPos]) - (afterVal * POW10[nextZeroPos]);
        return curBoard + (afterVal * POW10[curZeroPos]) + (beforeVal * POW10[nextZeroPos]);
    }
}
