#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void bt(int& k, const vector<vector<int>>& d, vector<bool>& b, int& result) {
    bool valid = false;
    
    for(int i=0; i<d.size(); i++) {
        if (!b[i] && k >= d[i][0]) {
            k -= d[i][1];
            b[i] = true;
            valid = true;
            bt(k, d, b, result);
            k += d[i][1];
            b[i] = false;
        }
    }
    
    if (!valid) {
        int cnt = 0;
        for(const bool& bo: b) if (bo) cnt++;
        result = max(result, cnt);
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = 0;
    vector<bool> b(dungeons.size(), false);
    bt(k, dungeons, b, answer);
    
    return answer;
}