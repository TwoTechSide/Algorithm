#include <string>
#include <vector>

using namespace std;

int solution(int left, int right) {
    vector<int> cnt(right + 1, 0);
    
    for (int i = 1; i <= right; i++) {
        for (int j = i; j <= right; j += i) {
            cnt[j]++;
        }
    }
    
    int answer = 0;
    for (int i = left; i <= right; i++) {
        if (cnt[i] % 2 == 0) answer += i;
        else answer -= i;
    }
    
    return answer;
}