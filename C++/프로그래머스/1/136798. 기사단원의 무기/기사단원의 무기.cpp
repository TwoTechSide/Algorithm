#include <vector>

using namespace std;

int divisorsCnt(int n) {
    int cnt = 0;
    int idx = 1;
    
    while (idx * idx < n) {
        if (n % idx == 0) cnt += 2;
        idx++;
    }
    
    return cnt + (idx * idx == n);
}

int solution(int number, int limit, int power) {
    int answer = 0;
    
    for (int i = 1; i <= number; i++) {
        int cnt = divisorsCnt(i);
        
        answer += cnt > limit ? power : cnt;
    }
    return answer;
}