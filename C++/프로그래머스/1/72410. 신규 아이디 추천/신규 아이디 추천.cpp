#include <string>
#include <vector>
#include <algorithm>
#include <cctype>
#include <regex>

using namespace std;

string solution(string new_id) {
    
    for(char& c: new_id) c = tolower(c);
    new_id = regex_replace(new_id, regex("[^a-z0-9-_.]"), "");
    new_id = regex_replace(new_id, regex("\\.+"), ".");
    new_id = regex_replace(new_id, regex("^\\.|\\.$"), "");
    if (new_id.empty()) new_id = "a";
    if (new_id.size() >= 16) new_id = new_id.substr(0, 15);
    new_id = regex_replace(new_id, regex("\\.$"), "");
    while (new_id.size() < 3) new_id += new_id.back();
    
    return new_id;
}