#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    
    if (n > m) swap(n, m);
    if (m % n == 0) return {n, m};
    
    int s;
    
    for (int i = n/2; i > 0; i--) {
        if ((n % i == 0) && (m % i == 0)) {
            s = i;
            break;
        }
    }
    
    return {s, n*m/s};
}