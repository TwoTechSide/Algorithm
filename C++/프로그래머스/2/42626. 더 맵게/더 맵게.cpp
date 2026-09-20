#include <string>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>> q;
    for(int& n: scoville) q.push(n);
    int answer = 0;
    
    while(q.top() < K && q.size() > 1) {
        int n1 = q.top(); q.pop();
        int n2 = q.top(); q.pop();
        q.push(n1+2*n2);
        answer++;
    }
    
    return q.top() >= K ? answer : -1;
}