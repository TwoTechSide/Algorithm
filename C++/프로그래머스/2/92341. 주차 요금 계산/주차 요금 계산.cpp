#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <sstream>

#include <iostream>

using namespace std;

vector<int> solution(vector<int> fees, vector<string> records) {
    
    unordered_map<int, int> in_time_map;
    unordered_map<int, int> ptime_map;
    
    auto timetoint = [](const int& a, const int& b) {return a*60+b;};
    
    int h, m, car_num;
    string inout;
    char col;
    
    for(const string& rcd: records) {
        istringstream iss(rcd);
        iss>>h>>col>>m>>car_num>>inout;
        
        int time = timetoint(h, m);
        
        if (inout == "IN") {
            in_time_map[car_num] = time;
        } else {
            ptime_map[car_num] += time-in_time_map[car_num];
            in_time_map.erase(car_num);
        }
    }
    
    int lasttime = timetoint(23, 59);
    for(const auto& p: in_time_map) ptime_map[p.first] += lasttime-p.second;
    
    map<int, int> fee_map;
    
    for(const auto& p: ptime_map) {
        int t = p.second;
        int f = fees[1];
        
        if (t > fees[0]) f += (t-fees[0]+fees[2]-1)/fees[2]*fees[3];
        fee_map[p.first] = f;
    }
    
    vector<int> answer;
    for(const auto& p: fee_map) answer.push_back(p.second);

    return answer;
}