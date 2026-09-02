#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr) {
    int answer = 0;
    
    while (true) {
        bool flag = false;
        
        for (int &n: arr) {
            if ((n >= 50) && ((n & 1) == 0)) {
                flag = true;
                n /= 2;
            }
            if ((n < 50) && ((n & 1) == 1)) {
                flag = true;
                n = n * 2 + 1;
            }
        }
        
        if (!flag)
            break;
        
        answer++;
    }
    
    return answer;
}