#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array) {
    int answer = 0;
    
    for (int n: array) {
        while (n > 0) {
            if ((n % 10) == 7) {
                answer++;
            }
            n /= 10;
        }
    }
    
    return answer;
}