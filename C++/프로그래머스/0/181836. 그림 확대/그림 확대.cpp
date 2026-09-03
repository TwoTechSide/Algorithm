#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> picture, int k) {
    vector<string> answer;
    int w = picture[0].size();
    int h = picture.size();
    
    for (int i = 0; i < h*k; i++) {
        string r = "";
        
        for (int j = 0; j < w*k; j++) {
            r += picture[i/k][j/k];
        }
        
        answer.emplace_back(r);
    }
    
    return answer;
}