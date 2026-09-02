#include <string>
#include <vector>

using namespace std;

int solution(int i, int j, int k) {
    int answer = 0;
    
    for (int n = i; n <= j; n++) {
        string numStr = to_string(n);
        
        for (char c: numStr) {
            if (c == k + '0') answer++;
        }
    }
    
    return answer;
}