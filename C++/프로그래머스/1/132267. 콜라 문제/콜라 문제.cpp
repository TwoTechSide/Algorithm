#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    
    while (n >= a) {
        int re = n/a*b;
        answer += re;
        n = (n%a)+re;
    }
    
    return answer;
}