#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<int> nums;
    
    while(n>0) {
        nums.push_back(n%10);
        n/=10;
    }
    
    sort(nums.rbegin(), nums.rend());
    
    for(const int &num: nums) {
        answer = answer * 10 + num;
    }
    
    return answer;
}