#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int range = 'z'-'a'+1;
    vector<int> letters(range);
    
    for (int i = 0; i < s.size(); i++) {
        letters[s[i]-'a']++;
    }
    
    string answer = "";
    for (int i = 0; i < range; i++) {
        if (letters[i] == 1) {
            answer += 'a' + i;
        }
    }
    
    return answer;
}