#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    
    int w = arr[0].size();
    int h = arr.size();
    
    if (w < h) {
        for (vector<int> &row: arr) row.resize(h);
    } else {
        for (int i = h; i < w; i++) {
            vector<int> new_vector(w, 0);
            arr.emplace_back(new_vector);
        }
    }
    
    return arr;
}