#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> wallet, vector<int> bill) {
    int answer = 0;
    
    int l = max(wallet[0], wallet[1]);
    int s = min(wallet[0], wallet[1]);
    
    while(true) {
        if ((max(bill[0], bill[1]) <= l) && (min(bill[0], bill[1]) <= s)) break;
        if (bill[0] > bill[1]) bill[0] /= 2;
        else bill[1] /= 2;
        
        answer++;
    }
    return answer;
}