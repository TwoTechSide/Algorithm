#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    const int N = arr1.size();
    vector<int> rows;
    vector<string> answer;
    
    for (int i = 0; i < N; i++) rows.push_back(arr1[i] | arr2[i]);
    
    for (int& row: rows) {
        string str;
        str.resize(N);
        
        int idx = N-1;
        
        for(int i = 0; i < N; i++) {
            str[idx--] = row % 2 ? '#' : ' ';
            row /= 2;
        }
        
        answer.push_back(str);
    }
    
    return answer;
}