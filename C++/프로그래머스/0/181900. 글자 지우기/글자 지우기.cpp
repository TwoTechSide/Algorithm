#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string my_string, vector<int> indices) {
    sort(indices.begin(), indices.end());
    indices.emplace_back(my_string.size() + 1);
    
    string answer = "";
    int element = 0;
    
    for (int i = 0; i < my_string.size(); i++) {
        if (indices[element] == i) {
            element++;
            continue;
        }
        
        answer += my_string[i];
    }
    
    return answer;
}