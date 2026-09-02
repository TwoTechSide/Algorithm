#include <string>
#include <vector>

using namespace std;

int solution(vector<string> strArr) {
    int answer = 0;
    vector<int> sizes(31);
    
    for (string str: strArr) {
        int &s = sizes[str.size()];
        s++;
        
        if (s > answer) {
            answer = s;
        }
    }
    
    return answer;
}