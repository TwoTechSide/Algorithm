#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    vector<int> nums = {5};
    
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] * 10 <= r) nums.push_back(nums[i] * 10);
        if (nums[i] * 10 + 5 <= r) nums.push_back(nums[i] * 10 + 5);
    }
    
    for (int n: nums) {
        if (l <= n) answer.push_back(n);
    }
    
    if (answer.empty()) answer.push_back(-1);
    
    return answer;
}