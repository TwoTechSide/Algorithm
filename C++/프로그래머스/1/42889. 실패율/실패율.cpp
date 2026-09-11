#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    unordered_map<int, int> um;
    vector<vector<int>> sf;
    
    int remain = stages.size();
    
    for(const int& stg: stages) um[stg]++;
    for(int i=1; i<=N; i++) {
        sf.push_back(vector<int>{i, remain, um[i]});
        remain -= um[i];
    }
    
    sort(sf.begin(), sf.end(), [](const vector<int>& a, const vector<int>& b) {
        long long n1 = 1LL * a[2] * b[1];
        long long n2 = 1LL * b[2] * a[1];
        if (n1 != n2) return n1 > n2;
        else return a[0] < b[0];
    });
    
    for(const vector<int>& s: sf) answer.push_back(s[0]);
    
    return answer;
}