#include <string>
#include <ctime>
#include <vector>

using namespace std;

string solution(int a, int b) {
    vector<string> s = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    tm t = {};
    t.tm_year = 2016 - 1900;
    t.tm_mon = a - 1;
    t.tm_mday = b;
    
    mktime(&t);
    
    return s[t.tm_wday];
}