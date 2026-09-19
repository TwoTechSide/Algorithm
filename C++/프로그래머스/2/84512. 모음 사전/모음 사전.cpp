#include <string>
#include <vector>
#include <stack>

using namespace std;

void search(string s, string& target, int& result, bool& find) {
    if (s == target) find = true;
    if (find) return;
    
    result++;
    
    if (s.size() < 5) {
        search(s+'A', target, result, find);
        search(s+'E', target, result, find);
        search(s+'I', target, result, find);
        search(s+'O', target, result, find);
        search(s+'U', target, result, find);
    }
}

int solution(string word) {
    int result = 0;
    bool find = false;
    
    search("", word, result, find);
    
    return result;
}