#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(const vector<int>& c: commands) {
        vector<int> v(array.begin()+c[0]-1, array.begin()+c[1]);
        sort(v.begin(), v.end());
        answer.push_back(v[c[2]-1]);
    }
    return answer;
}