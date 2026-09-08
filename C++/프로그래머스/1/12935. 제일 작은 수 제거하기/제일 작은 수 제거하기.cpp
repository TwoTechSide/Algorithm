#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    auto it = min_element(arr.begin(), arr.end());
    arr.erase(it);
    
    return arr.empty() ? vector<int>(1, -1) : arr;
}