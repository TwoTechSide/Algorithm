#include <string>
#include <vector>

using namespace std;

int solution(string ineq, string eq, int n, int m) {
    int answer = 0;
    string cond = ineq.append(eq);
    
    if (cond == "<=") return n <= m;
    else if (cond == ">=") return n >= m;
    else if (cond == "<!") return n < m;
    else return n > m;
}