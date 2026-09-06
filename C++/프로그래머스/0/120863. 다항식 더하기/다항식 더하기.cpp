#include <string>
#include <sstream>
#include <vector>

#include <iostream>

using namespace std;

string solution(string polynomial) {
    string answer = "";
    int xn = 0;
    int nn = 0;
    
    istringstream iss(polynomial);
    string token;
    
    while(iss >> token) {
        if (token.find("x") != string::npos) {
            token.resize(token.size()-1);
            xn += token.empty() ? 1 : stoi(token);
            continue;
        }
        
        if (token == "+") continue;
        
        nn += stoi(token);
    }
    
    if (xn > 0) {
        if (xn > 1) answer += to_string(xn);
        answer += "x";
    }
    
    if (!answer.empty() && nn > 0) answer += " + ";
    
    if (nn > 0) answer += to_string(nn);
    
    return answer;
}