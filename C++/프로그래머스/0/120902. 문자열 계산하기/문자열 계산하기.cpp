#include <string>
#include <vector>
#include <sstream>

#include <iostream>

using namespace std;

int solution(string my_string) {
    istringstream iss(my_string);
    
    vector<string> str_list;
    string token;
    
    while (iss >> token)
        str_list.emplace_back(token);
    
    int answer = stoi(str_list[0]);
    int idx = 1;
    
    while (idx < str_list.size()) {
        if (str_list[idx] == "+") answer += stoi(str_list[idx+1]);
        else answer -= stoi(str_list[idx+1]);
        idx += 2;
    }
    
    return answer;
}