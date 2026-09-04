#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    map<int, int> rank_map;
    
    for (int i = 0; i < rank.size(); i++) {
        if (attendance[i]) rank_map.insert({rank[i], i});
    }
    
    int answer = 0;
    int mult = 10000;
    int count = 3;
    
    for (auto it = rank_map.begin(); count-- > 0; it++) {
        answer += mult * (it -> second);
        mult /= 100;
    }
    
    
    return answer;
}