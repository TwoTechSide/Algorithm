#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(string msg) {
    unordered_map<string, int> dict;
    vector<int> answer;
    int dict_idx = 27;
    int msg_idx = 0;
    string word = "";
    
    for(int i=0; i<26; i++) dict[string(1, 'A'+i)] = i+1;
    
    while(msg_idx < msg.length()) {
        if (!dict.contains(word+msg[msg_idx])) {
            dict[word+msg[msg_idx]] = dict_idx++;
            answer.push_back(dict[word]);
            word.clear();
        }
        word += msg[msg_idx];
        msg_idx++;
    }
    
    answer.push_back(dict[word]);
    
    return answer;
}