#include <string>
#include <vector>
#include <utility>
#include <queue>
#include <unordered_set>

using namespace std;

int solution(int x, int y, int n) {
    unordered_set<int> us;
    queue<pair<int, int>> q;
    q.push(make_pair(x, 0));
    
    while(!q.empty()) {
        pair<int, int> p = q.front();
        q.pop();
        
        if (p.first == y) return p.second;
        if (p.first > y || us.find(p.first) != us.end()) continue;
        
        us.insert(p.first);
        
        q.push(make_pair(p.first+n, p.second+1));
        q.push(make_pair(p.first*2, p.second+1));
        q.push(make_pair(p.first*3, p.second+1));
    }
    
    return -1;
}