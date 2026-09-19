#include <string>
#include <vector>
#include <unordered_set>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    unordered_set<int> us;
    int left = 0;
    int right = 0;
    vector<int> answer;
    vector<string> tuples;
    s = s.substr(1, s.size()-2);
    
    while(s.find('{', left) != string::npos) {
        left = s.find('{', left);
        right = s.find('}', left);
        tuples.push_back(s.substr(left+1, right-left-1));
        left++;
    }
    
    sort(tuples.begin(), tuples.end(), [](const string& s1, const string& s2) {
        return s1.size() < s2.size();
    });
    
    for(const string str: tuples) {
        istringstream iss(str);
        string token;
        
        while(getline(iss, token, ',')) {
            int n = stoi(token);
            
            if (us.find(n) == us.end()) {
                answer.push_back(n);
                us.insert(n);
                break;
            }
        }
    }
    
    return answer;
}