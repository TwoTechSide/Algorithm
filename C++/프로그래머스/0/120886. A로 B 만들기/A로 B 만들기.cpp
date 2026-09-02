#include <string>
#include <vector>

using namespace std;

int solution(string before, string after) {
    int range = 'z'-'a'+1;
    vector<int> counts(range);
    
    for (int i = 0; i < before.size(); i++) {
        counts[before[i]-'a']++;
        counts[after[i]-'a']--;
    }
    
    for (int i = 0; i < range; i++) {
        if (counts[i] != 0)
            return 0;
    }
    
    return 1;
}