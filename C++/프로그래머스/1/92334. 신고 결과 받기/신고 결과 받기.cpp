#include <string>
#include <vector>
#include <sstream>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    unordered_map<string, vector<string>> rpt_list;
    unordered_map<string, int> rpt_count;
    
    for(const string& id: id_list) rpt_list[id] = vector<string>();
    
    for(const string& rpt: report) {
        istringstream iss(rpt);
        string from;
        string to;
        iss >> from >> to;
        
        if (find(rpt_list[from].begin(), rpt_list[from].end(), to) == rpt_list[from].end()) {
            rpt_list[from].emplace_back(to);
            rpt_count[to]++;
        }
    }
    
    for(const string& id: id_list) {
        int ban_count = 0;
        const vector<string>& s = rpt_list[id];
        
        for(const string& rpt_id: s) {
            if (rpt_count[rpt_id] >= k) ban_count++;
        }
        
        answer.push_back(ban_count);
    }
    
    return answer;
}