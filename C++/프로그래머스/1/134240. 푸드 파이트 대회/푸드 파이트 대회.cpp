#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    
    string ord = "";
    for (int i = 1; i < food.size(); i++) ord += string(food[i]/2, '0'+i);
    
    answer += ord + "0";
    reverse(ord.begin(), ord.end());
    answer += ord;
    
    return answer;
}