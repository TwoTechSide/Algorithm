#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    int l = 'z'-'a'+1;
    vector<int> c(l,-1);
    vector<int> answer;
    
    for (int i=0; i<s.size(); i++) {
        int* last_pos = &c[s[i] - 'a'];
        
        if (*last_pos == -1) answer.push_back(-1);
        else answer.push_back(i - (*last_pos));
        *last_pos = i;
    }
    return answer;
}