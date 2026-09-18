#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer(right-left+1);
    
    for(long long i=left; i<=right; i++) {
        long long p = i/n+1;
        answer[i-left] = max(i%n+1, p);
    }
    return answer;
}