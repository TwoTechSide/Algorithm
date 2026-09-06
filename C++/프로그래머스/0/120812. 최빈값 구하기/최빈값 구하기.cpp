#include <string>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

int solution(vector<int> array) {
    vector<int> count(1001);
    int max_count = 0;
    int answer = 0;
    
    for(int n: array) {
        count[n]++;
        if (count[n] > max_count) {
            max_count = count[n];
            answer = n;
        }
    }
    
    sort(count.begin(), count.end(), greater<int>());
    
    if (count.size() > 1 && count[0] == count[1]) return -1;
    return answer;
}