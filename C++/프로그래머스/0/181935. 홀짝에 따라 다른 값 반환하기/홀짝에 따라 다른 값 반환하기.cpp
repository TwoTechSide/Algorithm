#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int m = n/2;
    return ((n & 1) == 0) ? 2*m*(m+1)*(m*2+1)/3 : (m+1)*(m+1);
}