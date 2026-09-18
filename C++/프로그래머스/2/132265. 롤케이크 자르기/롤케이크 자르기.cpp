#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>

using namespace std;

int solution(vector<int> topping) {
    unordered_set<int> left;
    unordered_map<int, int> right;
    
    for(const int& i: topping) right[i]++;
    
    int answer = 0;
    
    for(const int& i: topping) {
        left.insert(i);
        if (--right[i] == 0) right.erase(i);
        if (left.size() == right.size()) answer++;
    }
    
    return answer;
}