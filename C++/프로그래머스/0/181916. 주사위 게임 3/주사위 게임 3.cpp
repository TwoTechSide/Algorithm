#include <string>
#include <vector>
#include <utility>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(int a, int b, int c, int d) {
    vector<int> dice_cnt(7);
    
    dice_cnt[a]++;
    dice_cnt[b]++;
    dice_cnt[c]++;
    dice_cnt[d]++;
    
    vector<pair<int, int>> pair_v;
    
    for (int i = 1; i <= 6; i++) {
        pair<int, int> p = make_pair(i, dice_cnt[i]);
        pair_v.push_back(p);
    }
    
    sort(pair_v.begin(), pair_v.end(), [](const pair<int, int> &a, const pair<int, int> &b) {
        return a.second > b.second;
    });
    
    if (pair_v[0].second == 4) { return pair_v[0].first * 1111; }
    else if (pair_v[0].second == 3) {
        int score = pair_v[0].first * 10 + pair_v[1].first;
        return score * score;
    } else if (pair_v[0].second == 2) {
        if (pair_v[1].second == 2) {
            return (pair_v[0].first + pair_v[1].first) * abs(pair_v[0].first - pair_v[1].first);
        } else {
            return (pair_v[1].first * pair_v[2].first);
        }
    } else return min(min(a, b), min(c, d));
}