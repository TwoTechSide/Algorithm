#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> str_list) {
    vector<string> answer;
    int dir = 0;
    int pos = 0;
    
    for (int i = 0; i < str_list.size(); i++) {
        if (str_list[i] == "l") {
            dir = -1;
            pos = i;
            break;
        } else if (str_list[i] == "r") {
            dir = 1;
            pos = i;
            break;
        }
    }
    
    if (dir == -1) {
        for (int i = 0; i < pos; i++) {
            answer.emplace_back(str_list[i]);
        }
    } else if (dir == 1) {
        for (int i = pos+1; i < str_list.size(); i++) {
            answer.emplace_back(str_list[i]);
        }
    }
    
    return answer;
}