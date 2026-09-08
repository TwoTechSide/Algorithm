#include <string>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    
    for(int i = 0; i <= t.size() - p.size(); i++) {
        string slice = t.substr(i, p.size());
        if (p.compare(slice) >= 0) answer++;
    }
    
    return answer;
}