#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    for(const vector<string> v: photo) {
        int value = 0;
        
        for(const string& str: v) {
            auto it = find(name.begin(), name.end(), str);
            if (it == name.end()) continue;
            
            value += yearning[it-name.begin()];
        }
        answer.push_back(value);
    }
    return answer;
}