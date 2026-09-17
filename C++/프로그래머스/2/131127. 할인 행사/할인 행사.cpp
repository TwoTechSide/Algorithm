#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    unordered_map<string, int> um;
    int answer = 0;
    
    for(int i=0; i<want.size(); i++) um[want[i]] = number[i];
    for(int i=0; i<10; i++) um[discount[i]]--;
    
    for(int i=10; i<=discount.size(); i++) {
        bool valid = true;
        
        for(const string& str: want) {
            if (um[str] > 0) {
                valid = false;
                break;
            }
        }
        
        if (valid) answer++;
        if (i == discount.size()) break;
        
        um[discount[i]]--;
        um[discount[i-10]]++;
    }
    
    return answer;
}