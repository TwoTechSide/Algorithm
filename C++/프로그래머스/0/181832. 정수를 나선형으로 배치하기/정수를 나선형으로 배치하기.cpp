#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    
    vector<vector<int>> board(n, vector<int>(n, 0));
    
    vector<int> nx = {1, 0, -1, 0};
    vector<int> ny = {0, 1, 0, -1};
    int dir = 0;
    
    int x = 0;
    int y = 0;
    int idx = 1;
    
    for (int i = 0; i < n*n; i++) {
        board[y][x] = idx++;
        
        int dx = x + nx[dir];
        int dy = y + ny[dir];
        
        if (dx < 0 || dx >= n || dy < 0 || dy >= n || board[dy][dx] != 0) {
            dir = (dir + 1) % 4;
            
            dx = x + nx[dir];
            dy = y + ny[dir];
        }
        
        x = dx;
        y = dy;
    }
    
    return board;
}