#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int prev1 = num_list.back();
    num_list.pop_back();
    int prev2 = num_list.back();
    num_list.pop_back();
    
    num_list.push_back(prev2);
    num_list.push_back(prev1);
    
    num_list.push_back((prev1 > prev2) ? prev1 - prev2 : prev1 * 2);
    
    return num_list;
}