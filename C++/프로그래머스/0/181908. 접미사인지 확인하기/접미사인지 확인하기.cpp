#include <iostream>
#include <vector>

using namespace std;

int solution(string my_string, string is_suffix) {
    int len1 = my_string.size();
    int len2 = is_suffix.size();
    
    if (len1 < len2) return 0;
    
    return (is_suffix == (my_string.substr(len1 - len2, len1))) ? 1 : 0;
}