#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> land)
{
    vector<vector<int>> dp(land.size(), vector<int>(land[0].size()));
    for(int i=0; i<land[0].size(); i++) dp[0][i] = land[0][i];
    
    for(int i=1; i<land.size(); i++) {
        for(int j=0; j<land[0].size(); j++) {
            int mn = 0;
            for(int k=0; k<land[0].size(); k++) {
                if (j == k) continue;
                mn = max(mn, dp[i-1][k]);
            }
            dp[i][j] = land[i][j]+mn;
        }
    }
    
    int idx = land.size()-1;
    return *(max_element(dp[idx].begin(), dp[idx].end()));
}