#include <string>
#include <vector>
#include <bitset>

using namespace std;

int solution(int n) {
    bitset<30> bs1(n);
    int cnt = bs1.count();
    
    while(true) {
        n++;
        bitset<30> bs2(n);
        
        if (bs2.count() == cnt) break;
    }
    
    return n;
}