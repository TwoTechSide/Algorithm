#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string digits = "0123456789ABCDEF";

string dts(int n, const int& d) {
    string str = "";
    while(n>0) {
        str += digits[n%d];
        n/=d;
    }
    reverse(str.begin(), str.end());
    return str;
}

string solution(int n, int t, int m, int p) {
    string str = "0";
    int num = 1;
    
    while(str.size() < t*m) str += dts(num++, n);
    
    string answer = "";
    p -= 1;
    int idx = 0;
    
    while(answer.size() < t) answer += str[p + m*idx++];
    
    return answer;
}