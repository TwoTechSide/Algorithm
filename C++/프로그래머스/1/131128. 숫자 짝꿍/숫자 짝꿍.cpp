#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    sort(X.begin(), X.end(), greater<char>());
    sort(Y.begin(), Y.end(), greater<char>());
    
    int index=0;
    string answer = "";
    
    for(const char& c: X) {
        while(index < Y.size() && Y[index] > c) index++;
        if (c == Y[index]) {
            answer += c;
            index++;
        }
    }
    
    if (answer.empty()) return "-1";
    else if (answer[0] == '0') return "0";
    else return answer;
}