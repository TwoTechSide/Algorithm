#include <string>
#include <vector>

using namespace std;

string solution(string s, string skip, int index) {
    
    for(char& c: s) {
        int nx = c-'a';
        for(int i = 0; i < index; i++) {
            nx = ++nx%26;
            if (skip.find('a'+nx) != string::npos) i--;
        }
        c = 'a'+nx;
    }
    
    string answer = "";
    return s;
}