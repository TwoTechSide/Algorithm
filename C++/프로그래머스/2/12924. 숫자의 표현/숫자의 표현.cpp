#include <vector>
#include <unordered_map>

using namespace std;

int solution(int n) {
    int r = 0;
    int l = 0;
    int answer = 0;
    int sum = 0;
    
    while(r < n) {
        r++;
        sum += r;
        
        while (sum > n) {
            l++;
            sum -= l;
        }
        
        if (sum == n) answer++;
    }
    
    return answer;
}