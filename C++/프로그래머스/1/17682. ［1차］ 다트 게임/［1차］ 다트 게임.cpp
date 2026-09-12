#include <string>
#include <cctype>
#include <vector>

using namespace std;

int solution(string dartResult) {
    vector<int> score;
    int index = 0;
    int answer = 0;
    
    for(int i=0; i<3; i++) {
        size_t pos = dartResult.find_first_of("SDT", index);
        string score_str = dartResult.substr(index, pos-index);
        index = pos;
        
        int num = stoi(score_str);
        
        switch(dartResult[index]) {
            case 'S': score.push_back(num); break;
            case 'D': score.push_back(num*num); break;
            case 'T': score.push_back(num*num*num); break;
        }
        
        index++;
        
        if (dartResult[index] == '*') {
            score[i] *= 2;
            if (i > 0) score[i-1] *= 2;
            index++;
        } else if (dartResult[index] == '#') {
            score[i] *= -1;
            index++;
        }
    }
    
    for(const int& s: score) answer += s;
    
    return answer;
}