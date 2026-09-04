#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer;
    int x = 0;
    int y = 0;
    int hw = board[0]/2;
    int hh = board[1]/2;
    
    for (string str: keyinput) {
        if (str == "left") x -= (x > -hw);
        else if (str == "right") x += (x < hw);
        else if (str == "up") y += (y < hh);
        else if (str == "down") y -= (y > -hh);
    }
    
    answer.push_back(x);
    answer.push_back(y);
    
    return answer;
}