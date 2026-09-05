#include <string>
#include <vector>

using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db) {
    
    for (vector<string> personal_db: db) {
        if (id_pw[0] == personal_db[0]) {
            if (id_pw[1] == personal_db[1]) return "login";
            else return "wrong pw";
        }
    }
    
    return "fail";
}