#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    string str = "";
    
    while(n > 0) {
        str += '0' + (n % 3);
        n /= 3;
    }
    
    return stoi(str, nullptr, 3);
}