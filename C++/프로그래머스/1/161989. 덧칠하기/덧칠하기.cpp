#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    
    while(section.size() > 0) {
        int start = section.front();
        
        while(true) {
            
            if (section.size() > 0 && section.front() < start + m) {
                section.erase(section.begin());
            } else {
                answer++;
                break;
            }
        }
    }
    return answer;
}