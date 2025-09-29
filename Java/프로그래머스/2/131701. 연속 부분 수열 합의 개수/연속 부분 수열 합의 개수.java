import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {

        int[] preSum = new int[elements.length*2+1];
        preSum[0] = 0;

        for (int i = 0; i < elements.length*2; i++)
            preSum[i+1] = preSum[i] + elements[i%elements.length];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j <= elements.length; j++) {
                set.add(preSum[i+j] - preSum[i]);
            }
        }

        return set.size();
    }
}