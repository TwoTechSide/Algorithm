#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    unordered_map<char, int> uo_map;
    
    for(const string& t: targets) {
        int result = 0;
        bool possible = true;
        
        for(const char& c: t) {
            if (!uo_map.contains(c)) {
                int min_typing = 101;
                for(const string& k: keymap) {
                    auto f = k.find(c);
                    if (f == string::npos) continue;
                    if (f+1 < min_typing) min_typing = f+1;
                }
                uo_map[c] = min_typing;
            }
            
            if (uo_map[c] > 100) {
                possible = false;
                break;
            } 
            result += uo_map[c];
        }
        if (possible) answer.push_back(result);
        else answer.push_back(-1);
    }
    
    return answer;
}