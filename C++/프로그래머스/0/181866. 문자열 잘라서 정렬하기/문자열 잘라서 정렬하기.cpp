#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(string myString) {
    for (char &c: myString) {
        if (c == 'x') c = ' ';
    }
    
    vector<string> answer;
    istringstream iss(myString);
    
    string token;
    while (iss >> token) {
        answer.push_back(token);
    }
    
    sort(answer.begin(), answer.end());
    
    return answer;
}