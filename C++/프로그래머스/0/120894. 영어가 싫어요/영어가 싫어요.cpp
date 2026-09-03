#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

long long solution(string numbers) {
    unordered_map<string, string> n_map = {
        {"zero", "0"},
        {"one", "1"},
        {"two", "2"},
        {"three", "3"},
        {"four", "4"},
        {"five", "5"},
        {"six", "6"},
        {"seven", "7"},
        {"eight", "8"},
        {"nine", "9"}
    };
    
    for (auto& p: n_map) {
        size_t pos = numbers.find(p.first);
        
        while (pos != string::npos) {
            numbers.replace(pos, p.first.size(), p.second);
            pos = numbers.find(p.first);
        }
    }
    
    return stoll(numbers);
}