#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> stk;
    vector<bool> b(order.size()+1, false);
    int idx = 1;
    
    for(const int& o: order) {
        if (b[o] == false) {
            while(idx < o) {
                stk.push(idx);
                b[idx] = true;
                idx++;
            }
        } else {
            if (stk.top() == o) stk.pop();
            else break;
        }
        
        idx++;
        answer++;
    }
    
    return answer;
}