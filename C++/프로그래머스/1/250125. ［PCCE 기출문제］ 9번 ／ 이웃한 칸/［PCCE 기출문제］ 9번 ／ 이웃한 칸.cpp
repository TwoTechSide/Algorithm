#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> board, int h, int w) {
    int cnt = 0;
    int l = board.size();
    vector<int> dx = {0, 1, 0, -1};
    vector<int> dy = {1, 0, -1, 0};
    
    for(int i = 0; i < 4; i++) {
        int nx = h + dx[i];
        int ny = w + dy[i];
        
        if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
        if (board[h][w] == board[nx][ny]) cnt++;
    }
    
    return cnt;
}