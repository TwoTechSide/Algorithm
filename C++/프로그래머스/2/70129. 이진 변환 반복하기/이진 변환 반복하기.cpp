#include <string>
#include <vector>
#include <algorithm>

#include <iostream>

using namespace std;

int func(string& s) {
    int cnt = 0;
    
    for(const char& c: s) if (c == '0') cnt++;
    
    int ns = s.size()-cnt;
    string tmp = "";
    
    while(ns > 0) {
        tmp += ns%2 ? "1" : "0";
        ns /= 2;
    }
    
    reverse(tmp.begin(), tmp.end());
    s = tmp;
    
    return cnt;
}

vector<int> solution(string s) {
    int total = 0;
    int func_cnt = 0;
    while(s != "1") {
        func_cnt++;
        total += func(s);
    }
    
    return {func_cnt, total};
}