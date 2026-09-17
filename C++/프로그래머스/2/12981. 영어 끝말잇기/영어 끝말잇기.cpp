#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    unordered_set<string> us;
    us.insert(words[0]);
    
    for(int i=1; i<words.size(); i++) {
        if (us.contains(words[i]) || words[i-1].back() != words[i].front()) return {i%n+1, i/n+1};
        us.insert(words[i]);
    }

    return {0, 0};
}