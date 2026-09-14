#include <string>
#include <vector>
#include <numeric>
#include <set>

using namespace std;

int solution(vector<vector<int>> signals) {
    vector<int> sgn_len;
    for(const vector<int>& sgn: signals) sgn_len.push_back(accumulate(sgn.begin(), sgn.end(), 0));
    
    int t = 0;
    vector<int> sgn_idx(signals.size(), 0);
    
    while(true) {
        bool valid = false;
        
        for(int i=0; i<signals.size(); i++) {
            int _t = t % sgn_len[i];
            if (_t < signals[i][0]) sgn_idx[i] = 0;
            else if (_t < signals[i][0] + signals[i][1]) sgn_idx[i] = 1;
            else sgn_idx[i] = 2;
            
            if (_t < sgn_len[i]-1) valid = true;
        }
        
        set<int> sgn_set(sgn_idx.begin(), sgn_idx.end());
        
        if (sgn_set.size() == 1 && *sgn_set.begin() == 1) return t+1;
        if (!valid) break;
        t++;
    }
    
    return -1;
}