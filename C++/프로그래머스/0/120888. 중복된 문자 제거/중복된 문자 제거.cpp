#include <string>
#include <vector>

using namespace std;

string solution(string my_string) {
    
    string answer = "";
    vector<bool> letter(256);
    
    for (int i = 0; i < my_string.size(); i++) {
        char c = my_string[i];
        
        if (!letter[c]) {
            letter[c] = true;
            answer += c;
        }
    }
    
    return answer;
}