#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    vector<int> len1;
    vector<int> len2;
    
    for(const vector<int>& v: sizes) {
        int w = v[0];
        int h = v[1];
        
        if (w < h) swap(w, h);
        
        len1.push_back(w);
        len2.push_back(h);
    }
    
    return (*max_element(len1.begin(), len1.end())) * (*max_element(len2.begin(), len2.end()));
}