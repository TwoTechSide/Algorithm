#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> result = players;
    unordered_map<string, int> pos;
    
    for(int i=0; i<players.size(); i++) pos[players[i]] = i;
    
    for(const string& call: callings) {
        int index = pos[call];
        swap(result[index], result[index-1]);
        
        pos[result[index]] = index;
        pos[result[index-1]] = index-1;
    }
    
    return result;
}