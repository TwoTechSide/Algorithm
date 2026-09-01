#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> arr) {
    
    for (int i = 0; i < arr.size()-1; i++) {
        for (int j = 1+i; j < arr.size(); j++) {
            
            if (arr[i][j] != arr[j][i])
                return 0;
        }
    }
    
    return 1;
}