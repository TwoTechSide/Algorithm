import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = s.length();
        char[] arr = s.repeat(2).toCharArray();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        int result = 0;

        for (int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>();

            stack.push(arr[i]);

            for (int j = 1; j < length; j++) {
                char c = arr[i+j];

                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        return result;
    }
}