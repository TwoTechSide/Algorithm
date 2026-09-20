#include <string>
#include <vector>
#include <stack>
#include <utility>

using namespace std;

vector<int> solution(vector<int> prices) {
    stack<pair<int, int>> stk;
    vector<int> answer(prices.size());
    
    for(int i=prices.size()-1; i>=0; i--) {
        while(!stk.empty() && stk.top().first >= prices[i]) stk.pop();
        
        if (stk.empty()) answer[i] = prices.size()-i-1;
        else answer[i] = stk.top().second-i;
        
        stk.push(make_pair(prices[i], i));
    }
    
    return answer;
}