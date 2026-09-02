#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(int n) {
    set<int> s;
    
    for (int i = 2; i * i <= n; i++) {
        while (n % i == 0) {
            s.insert(i);
            n /= i;
        }
    }
    
    if (n > 1) s.insert(n);
    vector<int> answer(s.begin(), s.end());
    
    return answer;
}