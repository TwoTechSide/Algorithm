#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    
    for (int i = 0; i < queries.size(); i++) {
        int p1 = queries[i][0];
        int p2 = queries[i][1];
        
        int &v1 = arr[p1];
        int &v2 = arr[p2];
        
        v1 ^= v2;
        v2 ^= v1;
        v1 ^= v2;
    }
    
    return arr;
}