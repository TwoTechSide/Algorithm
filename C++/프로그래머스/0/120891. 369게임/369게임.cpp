#include <string>
#include <vector>

using namespace std;

int solution(int order) {
    int answer = 0;
    
    while (order > 0) {
        int digit = order % 10;
        if (digit > 0 && (digit % 3) == 0) answer++;
        order /= 10;
    }
    
    return answer;
}