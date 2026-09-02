#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> stk;
    int i = 0;
    
    while (i < arr.size()) {
        if (stk.empty()) {
            stk.emplace_back(arr[i]);
            i++;
        } else if (stk.back() < arr[i]) {
            stk.emplace_back(arr[i]);
            i++;
        } else {
            stk.pop_back();
        }
    }
    
    return stk;
}