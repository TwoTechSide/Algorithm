#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    stack<int> st;
    vector<int> answer;
    
    for(int i=numbers.size()-1; i>=0; i--) {
        int n = numbers[i];
        
        while(!st.empty() && st.top() <= n) st.pop();
        
        if (st.empty()) answer.push_back(-1);
        else answer.push_back(st.top());
        
        st.push(n);
    }
    
    reverse(answer.begin(), answer.end());
    
    return answer;
}