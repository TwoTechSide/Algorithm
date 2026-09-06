#include <vector>

using namespace std;

int solution(vector<vector<int>> board) {
    
    int board_size = board.size();
    int answer = board_size*board_size;
    
    vector<vector<int>> n_board(board_size, vector<int>(board_size));
    vector<vector<int>> near = {
        {-1, -1},
        {0, -1},
        {1, -1},
        {-1, 0},
        {0, 0},
        {1, 0},
        {-1, 1},
        {0, 1},
        {1, 1}
    };
    
    for (int i = 0; i < board_size; i++) {
        for (int j = 0; j < board_size; j++) {
            if (board[i][j] == 1) {
                
                for (vector<int> next: near) {
                    int x = i + next[1];
                    int y = j + next[0];
                    
                    if (x < 0 || x >= board_size || y < 0 || y >= board_size) continue;
                    
                    if (n_board[x][y] == 0) {
                        n_board[x][y]++;
                        answer--;
                    }
                }
            }
        }
    }
    
    return answer;
}