#include <string>
#include <vector>

#include <iostream>

using namespace std;

int solution(int a, int b, int c) {
    bool cond1 = (a == b);
    bool cond2 = (b == c);
    bool cond3 = (a == c);
    
    int answer;
    
    if (cond1 && cond2) answer = (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c);
    else if (cond1 || cond2 || cond3) answer = (a+b+c)*(a*a+b*b+c*c);
    else answer = a+b+c;
    
    return answer;
}