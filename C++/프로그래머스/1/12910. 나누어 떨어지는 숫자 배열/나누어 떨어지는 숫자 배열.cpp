#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    
    sort(arr.begin(), arr.end());
    int mtp = 1;
    int max_value = *(arr.end()-1);
    
    while (divisor * mtp <= max_value) {
        if (find(arr.begin(), arr.end(), divisor * mtp) != arr.end()) {
            answer.push_back(divisor * mtp);
        }
        mtp++;
    }
    
    if (answer.empty()) answer.push_back(-1);
    return answer;
}