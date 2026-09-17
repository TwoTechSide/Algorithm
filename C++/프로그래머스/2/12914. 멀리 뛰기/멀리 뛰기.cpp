#include <string>
#include <vector>

using namespace std;

long long comb(int n, int r, vector<vector<int>>& tr) {
    if (r==n || r==0) return 1;
    if (tr[n][r] != -1) return tr[n][r];
    
    return tr[n][r] = (comb(n-1, r, tr)+comb(n-1, r-1, tr))%1234567;
}

long long solution(int n) {
    vector<int> ot = {n, 0};
    vector<vector<int>> tr(n+1, vector<int>(n+1, -1));
    
    if (n == 1) return 1;
    
    long long answer = 0;
    
    while(ot[0] >= 0) {
        answer = (answer + comb(ot[0]+ot[1], ot[1], tr)) % 1234567;
        
        ot[0] -= 2;
        ot[1] += 1;
    }
    
    return answer;
}