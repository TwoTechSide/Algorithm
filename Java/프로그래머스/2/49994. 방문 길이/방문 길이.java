import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        
        Set<String> set = new HashSet<>();

        int x = 5;
        int y = 5;

        for (int i = 0; i < dirs.length(); i++) {

            char c = dirs.charAt(i);

            int dx = (c == 'L') ? -1 : (c == 'R') ? 1 : 0;
            int dy = (c == 'D') ? -1 : (c == 'U') ? 1 : 0;

            int nx = x + dx;
            int ny = y + dy;

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10)
                continue;

            set.add(String.format("%d-%d-%d-%d", x, y, nx, ny));
            set.add(String.format("%d-%d-%d-%d", nx, ny, x, y));

            x = nx;
            y = ny;
        }

        return set.size()/2;
    }
}