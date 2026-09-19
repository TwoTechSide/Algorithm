#include <string>
#include <vector>
#include <list>
#include <algorithm>
#include <cctype>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int time = 0;
    list<string> cache;
    
    for(string& str: cities) {
        transform(str.begin(), str.end(), str.begin(), ::tolower);
        auto it = find(cache.begin(), cache.end(), str);
        
        if (it != cache.end()) {
            cache.splice(cache.end(), cache, it);
            time++;
        } else {
            cache.push_back(str);
            if (cache.size() > cacheSize) cache.pop_front();
            time += 5;
        }
    }
    
    return time;
}