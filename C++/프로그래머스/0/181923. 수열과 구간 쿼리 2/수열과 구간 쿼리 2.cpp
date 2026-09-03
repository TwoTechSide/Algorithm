#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    
    for (vector<int> v: queries) {
        int mx = 1000001;
        
        for (int i = v[0]; i <= v[1]; i++) {
            if (arr[i] > v[2] && arr[i] < mx) {
                mx = arr[i];
            }
        }
        
        if (mx <= 1000000) answer.push_back(mx);
        else answer.push_back(-1);
    }
    
    return answer;
}