#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    int h = brown/4;
    int w = brown/2 - h;
    
    while(true) {
        if (2*(h+w) == brown && (h-1)*(w-1) == yellow) break;
        h--;
        w++;
    }
    
    return {w+1, h+1};
}