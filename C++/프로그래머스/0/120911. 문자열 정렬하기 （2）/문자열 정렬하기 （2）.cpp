#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string my_string) {
    char d = 'A' - 'a';
    string answer = "";
    
    for(char c: my_string) {
        if ((c >= 'A') && (c <= 'Z')) c -= d;
        answer += c;
    }
    
    sort(answer.begin(), answer.end());
    return answer;
}