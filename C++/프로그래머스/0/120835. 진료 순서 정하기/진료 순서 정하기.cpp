#include <string>
#include <vector>
#include <map>
#include <algorithm>

#include <iostream>

using namespace std;

vector<int> solution(vector<int> emergency) {
    vector<int> sortEmergency = emergency;
    map<int, int> prMap;
    vector<int> answer;
    
    sort(sortEmergency.begin(), sortEmergency.end());
    int priority = emergency.size();
    
    for (int i = 0; i < sortEmergency.size(); i++) {
        prMap.insert({sortEmergency[i], priority--});
    }
    
    for (int i = 0; i < emergency.size(); i++) {
        answer.emplace_back(prMap.find(emergency[i])->second);
    }
    
    return answer;
}