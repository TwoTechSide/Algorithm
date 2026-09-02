#include <string>
#include <vector>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer(52);
    
    for (char c: my_string) {
        if ('a' <= c && c <= 'z') answer[26 + c - 'a']++;
        else if ('A' <= c && c <= 'Z') answer[c - 'A']++;
    }
    
    return answer;
}