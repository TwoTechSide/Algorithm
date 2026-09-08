#include <string>
#include <vector>
#include <stdexcept>

using namespace std;

bool solution(string s) {
    if (s.size() != 4 && s.size() != 6) return false;
    
    for(const char& c: s) {
        if (c < '0' || c > '9') return false;
    }
    
    return true;
}