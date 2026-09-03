#include <string>
#include <vector>

using namespace std;

int solution(vector<int> sides) {
    int answer = 0;
    
    return (sides[0] > sides[1] ? sides[1] : sides[0]) * 2 - 1;
}