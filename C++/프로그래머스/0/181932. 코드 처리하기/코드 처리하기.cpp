#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    bool mode = false;
    
    for (int i = 0; i < code.size(); i++) {
        
        char c = code[i];
        
        if (c == '1') {
            mode = !mode;
            continue;
        }
        
        if (!mode && (i & 1) == 0) answer += c;
        else if (mode && (i & 1) == 1) answer += c;
    }
    
    return answer.empty() ? "EMPTY" : answer;
}