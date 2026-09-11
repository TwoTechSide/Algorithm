#include <vector>
#include <bitset>
#include <algorithm>

#include <iostream>

using namespace std;

int solution(vector<int> nums) {
    int answer = 0;
    
    sort(nums.begin(), nums.end(), greater<int>());
    int max_num = nums[0]+nums[1]+nums[2];
    vector<bool> primes(max_num+1, true);
    primes[1] = false;
    
    for(int i=2; i<=max_num/2; i++) {
        for(int j=2; i*j<=max_num; j++) {
            primes[i*j] = false;
        }
    }
    
    for(int i=0; i<nums.size()-2; i++) {
        for(int j=i+1; j<nums.size()-1; j++) {
            for(int k=j+1; k<nums.size(); k++) {
                if (primes[nums[i]+nums[j]+nums[k]]) answer++;
            }
        }
    }

    return answer;
}