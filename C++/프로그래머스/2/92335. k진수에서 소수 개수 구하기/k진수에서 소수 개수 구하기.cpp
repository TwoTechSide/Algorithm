#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

bool is_prime(long long n) {
    if (n == 1) return false;
    for(long long i=2; i*i<=n; i++) if (n%i==0) return false;
    return true;
}

int solution(int n, int k) {
    string str = "";
    
    while(n>0) {
        str += '0'+n%k;
        n /= k;
    }
    
    reverse(str.begin(), str.end());
    
    istringstream iss(str);
    string token;
    int answer = 0;
    
    while(getline(iss, token, '0'))
        if (!token.empty() && is_prime(stoll(token))) answer++;
    
    return answer;
}