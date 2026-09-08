#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string s, int n) {
    
    for(char &c: s) {
        if (c == ' ') continue;
        
        if ('a' <= c && c <= 'z') c = 'a' + (c - 'a' + n) % 26;
        else c = 'A' + (c - 'A' + n) % 26;
    }
    
    return s;
}