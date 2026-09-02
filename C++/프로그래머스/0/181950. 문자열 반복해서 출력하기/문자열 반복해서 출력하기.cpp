#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int n;
    cin >> str >> n;
    
    while (n-- > 0) {
        cout << str;
    }
    
    return 0;
}