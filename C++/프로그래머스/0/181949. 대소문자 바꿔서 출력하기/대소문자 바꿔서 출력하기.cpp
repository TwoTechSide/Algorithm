#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    int rev = 'A' - 'a';
    string answer = "";
    
    for (int i = 0; i < str.length(); i++) {
        if ('a' <= str[i] && str[i] <= 'z') answer += str[i] + rev;
        else answer += str[i] - rev;
    }
    
    cout << answer;
    
    return 0;
}