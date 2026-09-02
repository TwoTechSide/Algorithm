#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<bool> flag) {
    vector<int> answer;
    
    for (int i = 0; i < arr.size(); i++) {
        int num = arr[i];
        
        if (flag[i]) {
            
            for (int j = 0; j < num*2; j++) {
                answer.emplace_back(num);
            }
        } else {
            for (int j = 0; j < num; j++) {
            answer.pop_back();
            }
        }
    }
    
    return answer;
}