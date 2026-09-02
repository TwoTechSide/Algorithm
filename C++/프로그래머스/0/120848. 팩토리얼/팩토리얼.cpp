#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int idx = 0;
    
    while (true) {
        n /= ++idx;
        if (n == 0) break;
    }
    
    return idx-1;
}