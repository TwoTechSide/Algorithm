#include <string>
#include <vector>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    
    int num = 0;
    for (int i = 0; i < my_string.size(); i++) {
        char c = my_string[i];
        
        if ('0' <= c && c <= '9') {
            num = num * 10 + (c - '0');
            continue;
        } else {
            answer += num;
            num = 0;
        }
    }
    
    return answer + num;
}