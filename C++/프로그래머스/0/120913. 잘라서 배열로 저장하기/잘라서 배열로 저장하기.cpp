#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_str, int n) {
    vector<string> answer;
    
    int idx = 0;
    while (true) {
        if (idx+n < my_str.size()) {
            answer.emplace_back(my_str.substr(idx, n));
            idx += n;
        } else {
            answer.emplace_back(my_str.substr(idx, my_str.size() - idx));
            break;
        }
    }
    
    return answer;
}