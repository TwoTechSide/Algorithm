#include <string>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

int solution(vector<int> d, int budget) {
    sort(d.begin(), d.end(), greater<int>());
    
    int total = accumulate(d.begin(), d.end(), 0);
    int des = 0;
    
    while (total > budget) {
        total -= d[des++];
    }
    
    return d.size() - des;
}