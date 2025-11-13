import java.io.IOException;
import java.util.*;

class Node {
    public char[] board;
    public int pos;
    public int cnt;

    public Node(char[] board, int pos, int cnt) {
        this.board = board;
        this.pos = pos;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return new String(this.board);
    }
}

public class Main {

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {

        char[] board = new char[9];
        Node root = null;

        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('0' + readInt());

            if (board[i] == '0')
                root = new Node(board, i, 0);
        }

        System.out.println(bfs(root));
    }

    public static int bfs(Node root) {

        Map<String, Boolean> isVisited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            // 만약 정렬된 경우 return
            if (curNode.toString().equals("123456780"))
                return curNode.cnt;

            // 방문 여부 적용
            if (isVisited.containsKey(curNode.toString())) continue;
            else isVisited.put(curNode.toString(), true);

            char[] curBoard = curNode.board;
            int curPos = curNode.pos;
            int nextCnt = curNode.cnt + 1;

            if (curPos > 2) {
                swap(curBoard, curPos, curPos-3);
                queue.add(new Node(Arrays.copyOf(curBoard, curBoard.length), curPos-3, nextCnt));
                swap(curBoard, curPos, curPos-3);
            }

            if (curPos < 6) {
                swap(curBoard, curPos, curPos+3);
                queue.add(new Node(Arrays.copyOf(curBoard, curBoard.length), curPos+3, nextCnt));
                swap(curBoard, curPos, curPos+3);
            }

            if (curPos % 3 != 0) {
                swap(curBoard, curPos, curPos-1);
                queue.add(new Node(Arrays.copyOf(curBoard, curBoard.length), curPos-1, nextCnt));
                swap(curBoard, curPos, curPos-1);
            }

            if (curPos % 3 != 2) {
                swap(curBoard, curPos, curPos+1);
                queue.add(new Node(Arrays.copyOf(curBoard, curBoard.length), curPos+1, nextCnt));
                swap(curBoard, curPos, curPos+1);
            }
        }

        return -1;
    }

    public static void swap(char[] board, int curPos, int nextPos) {
        board[curPos] ^= board[nextPos];
        board[nextPos] ^= board[curPos];
        board[curPos] ^= board[nextPos];
    }
}
