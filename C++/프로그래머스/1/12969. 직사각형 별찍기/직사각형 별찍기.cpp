#include <iostream>

using namespace std;

int main(void) {
    int a;
    int b;
    cin >> a >> b;
    
    string row(a, '*');
    while (b-- > 0) cout << row << endl;
    
    return 0;
}