#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

vector<string> solution(vector<string> files) {
    vector<string> heads;
    vector<int> numbers;
    vector<int> files_index;
    int file_idx = 0;
    
    for(string s: files) {
        int number = 0;
        int idx = 0;
        
        while('0' > s[idx] || s[idx] > '9') {
            s[idx] = tolower(s[idx]);
            idx++;
        }
        heads.push_back(s.substr(0, idx));
        
        while('0' <= s[idx] && s[idx] <= '9') number = number*10 + (s[idx++]-'0');
        numbers.push_back(number);
        
        files_index.push_back(file_idx++);
    }
    
    sort(files_index.begin(), files_index.end(), [&heads, &numbers](const int& a, const int& b) {
        if (heads[a] != heads[b]) return heads[a] < heads[b];
        else if (numbers[a] != numbers[b]) return numbers[a] < numbers[b];
        else return a < b;
    });
    
    vector<string> answer;
    for(const int& n: files_index) answer.emplace_back(files[n]);
    
    return answer;
}