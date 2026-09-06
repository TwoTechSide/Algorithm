#include <vector>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> quiz) {
    vector<string> answer;
    
    for(string q: quiz) {
        istringstream iss(q);
        string X;
        string op;
        string Y;
        string eq;
        string Z;
        
        iss >> X >> op >> Y >> eq >> Z;
        
        if (op == "+") {
            if (stoi(X) + stoi(Y) == stoi(Z)) answer.emplace_back("O");
            else answer.emplace_back("X");
        } else {
            if (stoi(X) - stoi(Y) == stoi(Z)) answer.emplace_back("O");
            else answer.emplace_back("X");
        }
    }
    
    return answer;
}