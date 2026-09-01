#include <iostream>
#include <string>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    
    string s = to_string(n) + (((n & 1) == 0) ? " is even" : " is odd");
    
    cout << s;
    return 0;
}