#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<vector<int>> score) {
    vector<int> sum_score;
    vector<int> sort_sum_score;
    vector<int> answer;
    
    for (vector<int> v: score) sum_score.push_back(v[0] + v[1]);
    sort_sum_score = sum_score;
    
    sort(sort_sum_score.rbegin(), sort_sum_score.rend());
    
    for (int sc: sum_score) {
        for (int i = 0; i < sum_score.size(); i++) {
            if (sc == sort_sum_score[i]) {
                answer.push_back(i+1);
                break;
            }
        }
    }
    
    return answer;
}