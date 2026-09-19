#include <vector>
#include <queue>

using namespace std;

int solution(vector<vector<int>> maps)
{
    queue<vector<int>> q;
    vector<int> dx = {1, 0, -1, 0};
    vector<int> dy = {0, 1, 0, -1};
    int w = maps[0].size();
    int h = maps.size();
    
    q.push({0, 0, 1});
    
    while(!q.empty()) {
        vector<int>& info = q.front();
        
        int x = info[0];
        int y = info[1];
        int move = info[2];
        
        if (x == w-1 && y == h-1) return move;
        
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if (nx<0 || nx>=w || ny<0 || ny>=h || maps[ny][nx]==0) continue;
            q.push({nx, ny, move+1});
            maps[ny][nx] = 0;
        }
        
        q.pop();
    }
    
    return -1;
}