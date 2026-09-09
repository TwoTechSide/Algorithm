#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    vector<int> buffer;
    
    for (const int& s: score) {
        auto it = lower_bound(buffer.begin(), buffer.end(), s);
        buffer.insert(it, s);
        
        int idx = buffer.size() > k ? buffer.size() - k : 0;
        answer.push_back(buffer[idx]);
    }
    return answer;
}