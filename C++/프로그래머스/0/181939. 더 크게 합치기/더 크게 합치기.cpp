#include <iostream>

using namespace std;

int solution(int a, int b) {
    
    int n1 = stoi(to_string(a) + to_string(b));
    int n2 = stoi(to_string(b) + to_string(a));
    return (n1 > n2) ? n1 : n2;
}