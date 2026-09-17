#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string s) {
    bool first = false;
    
    for(int i=0; i<s.length(); i++) {
        if (s[i] == ' ') {
            first = false;
            continue;
        }
        s[i] = !first ? toupper(s[i]) : tolower(s[i]);
        first = true;
    }
    
    return s;
}