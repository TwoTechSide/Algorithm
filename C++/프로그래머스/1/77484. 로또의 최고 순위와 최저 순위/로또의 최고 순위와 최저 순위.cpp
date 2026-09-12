#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    int unkn = 0;
    int kn = 0;
    
    for(const int& num: lottos) {
        if (num == 0) unkn++;
        else if (find(win_nums.begin(), win_nums.end(), num) != win_nums.end()) kn++;
    }
    
    int M = (kn + unkn) > 1 ? 7 - (kn + unkn) : 6;
    int m = kn > 1 ? 7 - kn : 6;
    
    return {M, m};
}