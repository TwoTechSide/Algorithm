#include <string>
#include <sstream>
#include <vector>

using namespace std;

int solution(string binomial) {
    istringstream iss(binomial);
    int a, b;
    char c;
    
    iss >> a >> c >> b;
    int answer;
    
    switch(c) {
        case '+': answer = a + b; break;
        case '-': answer = a - b; break;
        case '*': answer = a * b; break;
    }
    
    return answer;
}