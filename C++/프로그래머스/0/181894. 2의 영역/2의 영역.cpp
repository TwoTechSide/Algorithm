#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    
    int front = -1;
    int back = -1;
    
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == 2) {
            front = i;
            break;
        }
    }
    
    if (front == -1) {
        answer.push_back(-1);
        return answer;
    }
    
    for (int i = arr.size()-1; i >= 0; i--) {
        if (arr[i] == 2) {
            back = i;
            break;
        }
    }
    
    if (front == back) {
        answer.push_back(2);
        return answer;
    }
    
    for (int i = front; i <= back; i++) {
        answer.push_back(arr[i]);
    }
    
    return answer;
}