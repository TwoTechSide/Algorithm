#include <string>
#include <vector>
#include <sstream>
#include <unordered_map>

#include <iostream>

using namespace std;

int daytonum(string day, int mon = 0) {
    istringstream iss(day);
    int y;
    int m;
    int d;
    char dot;
    
    iss >> y >> dot >> m >> dot >> d;
    
    m += mon;
    while (m > 12) {
        m -= 12;
        y++;
    }
    
    return y * 10000 + m * 100 + d;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    unordered_map<char, int> unord_map;
    int d = daytonum(today);
    vector<int> answer;
    
    for(const string& str: terms) {
        istringstream iss(str);
        char c;
        int n;
        iss >> c >> n;
        unord_map[c] = n;
    }
    
    for(int i=0; i<privacies.size(); i++) {
        istringstream iss(privacies[i]);
        string date;
        char c;
        
        iss >> date >> c;
        int dl = daytonum(date, unord_map[c]);
        
        cout << "d, dl = " << d << ", " << dl << endl;
        
        if (d >= dl) answer.push_back(i+1);
    }
    
    return answer;
}