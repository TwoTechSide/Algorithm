#include <string>
#include <vector>
#include <utility>

using namespace std;

int func(const vector<vector<int>> &dots, int a, int b, int c, int d) {
    int dx1 = dots[b][0] - dots[a][0];
    int dy1 = dots[b][1] - dots[a][1];
    
    int dx2 = dots[d][0] - dots[c][0];
    int dy2 = dots[d][1] - dots[c][1];
    
    return dx1 * dy2 == dy1 * dx2;
}

int solution(vector<vector<int>> dots) {
    vector<pair<int, int>> lines;
    
    if (func(dots, 0, 1, 2, 3) ||
        func(dots, 0, 2, 1, 3) ||
        func(dots, 0, 3, 1, 2)) return 1;
    
    return 0;
}