#include <string>
#include <vector>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    int nu = numer1 * denom2 + numer2 * denom1;
    int de = denom1 * denom2;
    
    for (int i = 2; i <= de; i++) {
        while ((nu % i == 0) && (de % i == 0)) {
            nu /= i;
            de /= i;
        }
    }
    
    vector<int> answer;
    answer.push_back(nu);
    answer.push_back(de);
    return answer;
}