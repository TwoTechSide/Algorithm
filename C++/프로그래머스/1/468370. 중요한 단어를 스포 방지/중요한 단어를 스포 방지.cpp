#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

struct Word {
    int start_idx;
    int end_idx;
    string text;
    bool is_spoiler = false;
};

int solution(string message, vector<vector<int>> spoiler_ranges) {
    vector<bool> is_spoil_idx(message.size(), false);
    vector<Word> words;
    int idx = 0;

    for (const vector<int>& v : spoiler_ranges) {
        for (int i=v[0];i<= v[1]; i++)
            is_spoil_idx[i] = true;
    }

    istringstream iss(message);
    string str;
        
    while(message[idx] == ' ') idx++;

    while (iss >> str) {
        int len = str.size();
        bool has_spoil = false;

        for (int i=idx; i<idx+len; i++) {
            if (is_spoil_idx[i]) {
                has_spoil = true;
                break;
            }
        }

        words.emplace_back(idx, idx+len-1, str, has_spoil);
        idx += len+1;
    }

    sort(words.begin(), words.end(), [](const Word& w1, const Word& w2) {
        return w1.text < w2.text;
    });

    int answer = 0;

    for (int i=0; i<words.size();) {
        Word& w = words[i];
        bool is_spoil = true;

        while (i<words.size() && words[i].text == w.text) {
            is_spoil &= words[i].is_spoiler;
            i++;
        }

        if (is_spoil) answer++;
    }

    return answer;
}