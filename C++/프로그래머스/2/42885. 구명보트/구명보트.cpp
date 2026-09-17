#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    sort(people.begin(), people.end());
    int left = 0;
    int right = people.size()-1;
    
    while(left <= right) {
        while(people[left]+people[right] > limit && left < right) {
            answer++;
            right--;
        }
        answer++;
        left++;
        right--;
        
        if (left > right) break;
    }
    
    return answer;
}