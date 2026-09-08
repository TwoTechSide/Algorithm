#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string s) {
    int idx = 0;
    
    for(char &c: s) {
        if (c == ' ') {
            idx = 0;
            continue;
        }
        
        if (idx % 2 == 0) c = toupper(c);
        else c = tolower(c);
        
        idx++;
    }
    
    return s;
}