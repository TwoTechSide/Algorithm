#include <string>
#include <vector>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    
    for(int i = 0; i < my_strings.size(); i++) {
        string str = my_strings[i];
        vector<int> part =  parts[i];
        
        for (int j = part[0]; j <= part[1]; j++) {
            answer += str[j];
        }
    }
    
    return answer;
}