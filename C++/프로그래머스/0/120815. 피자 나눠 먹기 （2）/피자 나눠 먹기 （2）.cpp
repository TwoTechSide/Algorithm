#include <string>
#include <vector>

#include <iostream>

using namespace std;

int solution(int n) {
    
    int answer = 6;
    
    for (int i = 6; i > 0; i--) {
        if (((n % i) == 0) && ((6 % i) == 0)) {
            
            cout << i << endl;
            
            return n / i;
        }
    }
}