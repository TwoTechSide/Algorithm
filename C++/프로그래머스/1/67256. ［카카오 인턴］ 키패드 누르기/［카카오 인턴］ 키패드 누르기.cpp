#include <string>
#include <vector>
#include <cmath>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int li = 9;
    int ri = 11;
    
    for(int num: numbers) {
        if (num == 0) num = 10;
        else num -= 1;
        
        if (num % 3 == 0) {
            li = num;
            answer += "L";
        } else if (num % 3 == 2) {
            ri = num;
            answer += "R";
        } else {
            int left_len = abs(num/3 - li/3) + (li % 3 == 0);
            int right_len = abs(num/3 - ri/3) + (ri % 3 == 2);
            
            if (left_len < right_len) {
                li = num;
                answer += "L";
            } else if (left_len > right_len) {
                ri = num;
                answer += "R";
            } else {
                if (hand == "left") {
                    li = num;
                    answer += "L";
                } else {
                    ri = num;
                    answer += "R";
                }
            }
        }
    }
    
    return answer;
}