#include <string>
#include <vector>

#include <iostream>

using namespace std;

int solution(vector<string> babbling) {
    vector<string> bab = {"aya", "ye", "woo", "ma"};
    
    for(string &str: babbling) {
        
        for(const string &b: bab) {
            while (str.find(b) != string::npos) {
                str.replace(str.find(b), b.size(), "-");
            }
        }
    }
    
    int answer = 0;
    for (const string &str: babbling) {
        bool flag = false;
        
        for (int i = 0; i < str.size(); i++) {
            if (str[i] != '-') {
                flag = true;
                break;
            }
        }
        
        if (!flag) answer++;
    }
    
    return answer;
}