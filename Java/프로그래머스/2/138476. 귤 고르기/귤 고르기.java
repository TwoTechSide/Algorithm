import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine) map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int answer = 0;
        for(int cnt : list) {
            k -= cnt;
            answer++;

            if (k <= 0) return answer;
        }

        return answer;
    }
}