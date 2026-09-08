#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    vector<string> str_nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    for (int i=0; i<str_nums.size(); i++) {
        const string& str_num = str_nums[i];
        while (s.find(str_num) != string::npos) s.replace(s.find(str_num), str_num.size(), to_string(i));
    }
    
    return stoi(s);
}