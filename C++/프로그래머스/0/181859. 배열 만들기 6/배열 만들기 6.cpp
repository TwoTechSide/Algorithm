#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> stk;
    int i = 0;
    
    while (i < arr.size()) {
        if (stk.empty()) {
            stk.push_back(arr[i]);
            i++;
        } else if (stk.back() == arr[i]) {
            stk.pop_back();
            i++;
        } else {
            stk.push_back(arr[i]);
            i++;
        }
    }
    
    if (stk.empty())
        stk.push_back(-1);
    
    return stk;
}