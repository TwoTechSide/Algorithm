#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> has(n+2, 1);
    vector<bool> lent(n+1, false);
    for(const int& l: lost) has[l] = 0;
    
    sort(reserve.begin(), reserve.end());
    
    for(const int& r: reserve) {
        if (has[r] == 0) {
            has[r] = 1;
            lent[r] = true;
        }
    }
    
    for(const int& r: reserve) {
        if (lent[r]) continue;
        
        if (has[r-1] == 0) has[r-1] = 1;
        else if (has[r+1] == 0) has[r+1] = 1;
    }
    
    int answer = 0;
    for(int i = 1; i <= n; i++) answer += has[i];
    
    return answer;
}