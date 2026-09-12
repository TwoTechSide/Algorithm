#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;


vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    unordered_map<string, int> unord_map;
    unord_map["code"] = 0;
    unord_map["date"] = 1;
    unord_map["maximum"] = 2;
    unord_map["remain"] = 3;
    
    int sort_by_index = unord_map[sort_by];
    int ext_index = unord_map[ext];
    
    vector<vector<int>> answer;
    
    for(const vector<int>& d: data) {
        if (d[ext_index] < val_ext) answer.push_back(d);
    }
    
    sort(answer.begin(), answer.end(), [sort_by_index](const vector<int>& a, const vector<int>& b) {
        return a[sort_by_index] < b[sort_by_index];
    });
    
    return answer;
}