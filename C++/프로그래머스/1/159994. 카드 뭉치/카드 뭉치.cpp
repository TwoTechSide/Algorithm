#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    
    for(const string& str: goal) {
        if (cards1.front() == str) cards1.erase(cards1.begin());
        else if (cards2.front() == str) cards2.erase(cards2.begin());
        else return "No";
    }
    
    return "Yes";
}