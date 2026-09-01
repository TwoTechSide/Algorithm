#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numLog) {
    string answer = "";
    
    int prev = numLog.front();
    
    for (int i = 1; i < numLog.size(); i++) {
        int move = numLog.at(i) - prev;
        
        switch(move) {
            case 1: answer += "w"; break;
            case -1: answer += "s"; break;
            case 10: answer += "d"; break;
            case -10: answer += "a"; break;
        }
        
        prev += move;
    }
    
    return answer;
}