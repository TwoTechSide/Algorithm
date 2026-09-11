#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> a = {1, 2, 3, 4, 5};
    vector<int> b = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    vector<vector<int>> students = {a, b, c};
    vector<int> score(3, 0);
    
    for(int i=0; i<answers.size(); i++) {
        for (int j=0; j<3; j++) {
            const vector<int>& s = students[j];
            score[j] += (answers[i] == s[i % s.size()]);
        }
    }
    
    vector<vector<int>> total_score;
    for (int i=1; i<=3; i++) total_score.emplace_back(vector<int>{i, score[i-1]});
    
    sort(total_score.begin(), total_score.end(), [](const vector<int>& a, const vector<int>& b) {
        if (a[0] == b[0]) return a[0] < b[0];
        else return a[1] > b[1];
    });
    
    int max_score = total_score[0][1];

    vector<int> answer;
    for(const vector<int>& v: total_score) {
        if (v[1] == max_score) answer.push_back(v[0]);
        else break;
    }
    
    return answer;
}