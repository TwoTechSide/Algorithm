#include <string>
#include <vector>

using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    for (string str_dic: dic) {
        bool flag = false;
        
        for (string str_spell: spell) {
            if (str_dic.find(str_spell) == string::npos) {
                flag = true;
                break;
            }
        }
        
        if (!flag) return 1;
    }
    
    return 2;
}