#include <string>
#include <vector>

using namespace std;

string solution(int age) {
    
    string str = to_string(age);
    string answer = "";
    
    for (char c: str) {
        answer += 'a' + c - '0';
    }
    
    return answer;
}