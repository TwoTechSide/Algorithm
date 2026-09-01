#include <string>
#include <vector>
#include <algorithm>

#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    vector<int> add_v(arr.size() + 1);
    
    int minValue = 1000000;
    int maxValue = 0;
    
    for (vector<int> query: queries) {
        int front = query[0];
        int back = query[1];
        
        minValue = min(minValue, front);
        maxValue = max(maxValue, back);
        
        add_v[front]++;
        add_v[back+1]--;
    }
    
    int add_num = 0;
    
    for (int i = minValue; i <= maxValue; i++) {
        add_num += add_v[i];
        arr[i] += add_num;
    }
    
    return arr;
}