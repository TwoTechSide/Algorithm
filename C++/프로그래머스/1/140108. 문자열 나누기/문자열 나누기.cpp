#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    char c;
    int index = 1;
    int count = 0;
    
    for(int i=0; i<s.size(); i++) {
        if (count == 0) {
            c = s[i];
            count = 1;
            answer++;
        } else count += (c == s[i]) ? 1 : -1;
    }
    
    return answer;
}