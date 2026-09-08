#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    long long l = sqrt(n);
    
    if (l * l == n) return (l+1) * (l+1);
    else return -1;
}