#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> unord_map;
    vector<int> cc;
    
    for(const vector<string>& v: clothes) unord_map[v[1]]++;
    for(const auto& m: unord_map) answer *= m.second+1;
    
    return answer-1;
}