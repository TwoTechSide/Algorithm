#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> dots) {
    
    int x1 = dots[0][0];
    int y1 = dots[0][1];
    
    int x2 = (dots[1][0] != x1) ? dots[1][0] : dots[2][0];
    int y2 = (dots[1][1] != y1) ? dots[1][1] : dots[2][1];
    
    int answer = (x1 - x2) * (y1 - y2);
    
    return (answer < 0) ? -answer : answer;
}