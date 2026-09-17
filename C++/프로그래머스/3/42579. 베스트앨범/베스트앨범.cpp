#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    unordered_map<string, int> genre_cnt;
    vector<int> srt;
    
    for(int i=0; i<genres.size(); i++) {
        genre_cnt[genres[i]] += plays[i];
        srt.push_back(i);
    }
    
    sort(srt.begin(), srt.end(), [&genre_cnt, &genres, &plays](const int& a, const int& b) {
        if (genre_cnt[genres[a]] != genre_cnt[genres[b]])
            return genre_cnt[genres[a]] > genre_cnt[genres[b]];
        else if (plays[a] != plays[b])
            return plays[a] > plays[b];
        else
            return a < b;
    });
    
    string str = "";
    bool b = false;
    
    vector<int> answer;
    
    for(const int& i: srt) {
        if (str != genres[i]) {
            b = false;
            str = genres[i];
        } else {
            if (!b) b = true;
            else continue;
        }
        answer.push_back(i);
    }
    
    return answer;
}