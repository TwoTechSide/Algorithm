#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    int n = 0;
    
    for(const char &c: s) {
        if (c == 'p' || c == 'P') n++;
        else if (c == 'y' || c == 'Y') n--;
    }

    return n == 0;
}