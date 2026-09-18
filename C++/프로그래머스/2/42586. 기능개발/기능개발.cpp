#include <string>
#include <vector>

#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    int idx = 0;
    int d = (100-progresses[0]-1)/speeds[0]+1;
    vector<int> answer;
    
    cout << d << endl;
    
    while(true) {
        int n = 0;
        while(idx < progresses.size() && progresses[idx]+speeds[idx]*d >= 100) {
            idx++;
            n++;
        }
        answer.push_back(n);
        if (idx >= progresses.size()) break;
        else d = (100-progresses[idx]-1)/speeds[idx]+1;
    }
    return answer;
}