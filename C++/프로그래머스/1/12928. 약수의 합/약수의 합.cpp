#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int idx = 1;
    
    while (idx*idx < n) {
        if (n % idx == 0) answer += (idx + (n / idx));
        idx++;
    }
    
    if (idx * idx == n) answer += idx;
    
    return answer;
}