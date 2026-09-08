#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1;
    while (n % answer != 1) answer++;
    
    return answer;
}