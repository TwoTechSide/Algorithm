#include <string>
#include <vector>

using namespace std;

int comb(int n, int r) {
    if (r == 0 || n == r) return 1;
    return comb(n-1, r-1) + comb(n-1, r);
}

int solution(int balls, int share) {
    return comb(balls, share);
}