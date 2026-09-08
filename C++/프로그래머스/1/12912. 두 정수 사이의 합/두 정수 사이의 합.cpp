#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(int a, int b) {
    long long s = min(a, b);
    long long l = max(a, b);
    
    return (s + l) * (l - s + 1) / 2;
}