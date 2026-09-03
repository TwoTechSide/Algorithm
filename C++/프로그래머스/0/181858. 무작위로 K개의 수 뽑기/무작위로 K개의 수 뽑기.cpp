#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer;
    vector<bool> dd(100001);
    
    for (int i = 0; i < arr.size(); i++) {
        if (!dd[arr[i]]) {
            dd[arr[i]] = true;
            answer.push_back(arr[i]);
        }
        
        if (answer.size() >= k) break;
    }
    
    while (answer.size() < k) answer.push_back(-1);
    
    return answer;
}