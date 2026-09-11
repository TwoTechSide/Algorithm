#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<string> babbling) {
    vector<string> str = {"aya", "ye", "woo", "ma"};
    int answer = 0;
    
    for(string& ba: babbling) {
        bool flag = false;
        int ex_idx = -1;
        
        for(int i=0; i<str.size(); i++) {
            if (i == ex_idx) continue;
            
            if (ba.find(str[i]) == 0) {
                ba.erase(0, str[i].size());
                ex_idx = i;
                i = -1;
            }
        }
        
        if (ba.empty()) answer++;
    }
    
    return answer;
}