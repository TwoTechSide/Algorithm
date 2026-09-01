#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int n1 = stoi(to_string(a) + to_string(b));
    int n2 = 2 * a * b;
    
    return (n1 > n2) ? n1 : n2;
}