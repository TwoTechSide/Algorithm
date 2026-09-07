#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

int solution(vector<vector<int>> lines) {
    vector<pair<int, int>> dots;
    
    for (const vector<int> &line: lines) {
        dots.emplace_back(make_pair(line[0], 1));
        dots.emplace_back(make_pair(line[1], -1));
    }
    
    sort(dots.begin(), dots.end(), [](const pair<int, int> &a, const pair<int, int> &b) {
        if (a.first == b.first) return a.second < b.second;
        else return a.first < b.first;
    });
    
    int l = 0;
    int p = 0;
    int answer = 0;
    
    for(const pair<int, int> &dot: dots) {
        l += dot.second;
        
        if (l == 2 && dot.second == 1) p = dot.first;
        else if (l == 1 && dot.second == -1) answer += dot.first - p;
    }
    
    return answer;
}