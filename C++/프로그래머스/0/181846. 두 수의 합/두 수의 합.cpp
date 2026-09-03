#include <string>
#include <vector>

#include <algorithm>

using namespace std;

string solution(string a, string b) {
    
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());
    
    int max_leng = max(a.size(), b.size());
    bool ov = false;
    string answer = "";
    
    for (int i = 0; i < max_leng; i++) {
        int d = 0;
        if (i < a.size()) d += a[i] - '0';
        if (i < b.size()) d += b[i] - '0';
        if (ov) d++;
        answer = to_string(d % 10) + answer;
        
        ov = false;
        if (d >= 10) ov = true;
    }
    
    if (ov)
        answer = '1' + answer;
    
    return answer;
}