import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        List<Deque<Integer>> list = new ArrayList<>();
        Deque<Integer> cart = new LinkedList<>();

        for (int col = 0; col < board[0].length; col++) {
            list.add(new LinkedList<>());
            Deque<Integer> deque = list.get(col);

            for (int[] rows : board) {
                if (rows[col] > 0) deque.addLast(rows[col]);
            }
        }

        int result = 0;

        for (int move: moves) {
            Deque<Integer> deque = list.get(move-1);

            if (!deque.isEmpty()) {
                int item = deque.removeFirst();

                if (!cart.isEmpty() && item == cart.getFirst()) {
                    cart.removeFirst();
                    result += 2;
                } else {
                    cart.addFirst(item);
                }
            }
        }

        return result;
    }
}