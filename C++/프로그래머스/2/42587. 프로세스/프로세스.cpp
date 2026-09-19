#include <string>
#include <vector>
#include <utility>
#include <algorithm>
#include <functional>
#include <queue>

#include <iostream>

using namespace std;

int solution(vector<int> priorities, int location) {
    queue<pair<int, int>> q;
    vector<int> sorted_priorities;
    int sorted_idx = 0;
    int process_idx = 1;
    
    for(int i=0; i<priorities.size(); i++) {
        q.push(pair<int, int>(priorities[i], i));
        sorted_priorities.push_back(priorities[i]);
    }
    
    sort(sorted_priorities.begin(), sorted_priorities.end(), greater<int>());
    
    while(!q.empty()) {
        pair<int, int> p = q.front();
        if (p.first == sorted_priorities[sorted_idx]) {
            if (p.second == location) return process_idx;
            process_idx++;
            sorted_idx++;
        } else {
            q.push(p);
        }
        q.pop();
    }
    
    return 0;
}