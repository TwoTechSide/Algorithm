#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    unordered_map<char, int> um;
    int answer = skill_trees.size();
    
    for(int i=0; i<skill.length(); i++) um[skill[i]] = i;
    
    for(const string& s: skill_trees) {
        int idx = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s[i];
            if (um.contains(c) && um[c] != idx++) {
                answer--;
                break;
            }
        }
    }
    
    return answer;
}