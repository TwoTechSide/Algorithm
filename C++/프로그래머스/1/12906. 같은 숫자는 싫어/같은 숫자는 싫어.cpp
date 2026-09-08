#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;

    int b = arr[0];
    answer.push_back(b);
    
    for (int i = 1; i < arr.size(); i++) {
        if (arr[i] == b) continue;
        
        answer.push_back(arr[i]);
        b = arr[i];
    }

    return answer;
}