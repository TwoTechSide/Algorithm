#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int n = x;
    int s = 0;
    
    while (n > 0) {
        s += n % 10;
        n /= 10;
    }
    
    return (x % s) == 0;
}