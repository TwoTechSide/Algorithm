#include <stack>
#include <string>

using namespace std;

int solution(string s)
{
    stack<char> st;
    
    for(const char& c: s) {
        if (st.empty() || st.top() != c) st.push(c);
        else st.pop();
    }
    
    return st.empty() ? 1 : 0;
}