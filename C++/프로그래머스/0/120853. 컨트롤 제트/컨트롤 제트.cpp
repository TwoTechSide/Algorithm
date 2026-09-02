#include <string>
#include <vector>
#include <sstream>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    istringstream iss(s);
    string token;
    int lastNum;
    
    while (iss >> token) {
        if (token != "Z") {
            int num = stoi(token);
            answer += num;
            lastNum = num;
        } else {
            answer -= lastNum;
        }
    }
    
    return answer;
}