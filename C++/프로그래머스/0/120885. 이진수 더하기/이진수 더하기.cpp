#include <string>
#include <vector>
#include <bitset>

using namespace std;

string solution(string bin1, string bin2) {
    int result = stoi(bin1, nullptr, 2) + stoi(bin2, nullptr, 2);
    if (result == 0) return "0";
    
    string answer = "";
    
    while (result > 0) {
        answer = to_string(result & 1) + answer;
        result /= 2;
    }
    
    return answer;
}