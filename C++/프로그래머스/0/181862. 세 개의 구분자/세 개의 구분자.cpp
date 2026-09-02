#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> solution(string myStr) {
    
    for (int i = 0; i < myStr.size(); i++) {
        char &c = myStr[i];
        
        if (c == 'a' || c == 'b' || c == 'c') {
            c = ' ';
        }
    }
    
    istringstream iss(myStr);
    string token;
    vector<string> answer;
    
    while (iss >> token) {
        answer.emplace_back(token);
    }
    
    if (answer.empty()) {
        answer.emplace_back("EMPTY");
    }
    
    return answer;
}