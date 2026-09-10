#include <vector>
#include <set>

using namespace std;

int solution(vector<int> nums)
{
    set<int> s;
    for(const int& num: nums) s.insert(num);
    
    return s.size() < nums.size() / 2 ? s.size() : nums.size() / 2;
}