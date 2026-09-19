#include <string>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    const int n_size = numbers.size();
    queue<pair<int, int>> q;
    
    q.push(make_pair(numbers[0], 1));
    q.push(make_pair(-numbers[0], 1));
    
    while(!q.empty()) {
        auto p = q.front();
        q.pop();
        
        if (p.second >= n_size) {
            if (p.first == target) answer++;
            continue;
        }
        
        q.push(make_pair(p.first+numbers[p.second], p.second+1));
        q.push(make_pair(p.first-numbers[p.second], p.second+1));
    }
    
    return answer;
}