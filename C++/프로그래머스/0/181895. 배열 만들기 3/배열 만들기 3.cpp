#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> answer;
    
    for(vector<int> v: intervals) {
        int f = v.front();
        int b = v.back();
        
        for (int i = f; i <= b; i++) {
            answer.emplace_back(arr[i]);
        }
    }
    
    return answer;
}