#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

char psn(const int& sc1, const int& sc2, char psn1, char psn2) {
    if (sc1 > sc2) return psn1;
    if (sc1 < sc2) return psn2;
    
    return psn1 < psn2 ? psn1 : psn2;
}

string solution(vector<string> survey, vector<int> choices) {
    unordered_map<char, int> unord_map;
    
    for(int i = 0; i < survey.size(); i++) {
        const string& srv = survey[i];
        int choice = choices[i] - 4;
        
        if (choice < 0) unord_map[srv[0]] += -choice;
        else unord_map[srv[1]] += choice;
    }
    
    string answer = "";
    answer += psn(unord_map['R'], unord_map['T'], 'R', 'T');
    answer += psn(unord_map['C'], unord_map['F'], 'C', 'F');
    answer += psn(unord_map['J'], unord_map['M'], 'J', 'M');
    answer += psn(unord_map['A'], unord_map['N'], 'A', 'N');
    
    return answer;
}