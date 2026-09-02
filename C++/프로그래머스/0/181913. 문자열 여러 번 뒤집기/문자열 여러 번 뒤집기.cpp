#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    
    for (vector<int> query: queries) {
        int l = query[0];
        int r = query[1];
        
        while (l < r) {
            char &c1 = my_string[l];
            char &c2 = my_string[r];
            
            c1 ^= c2;
            c2 ^= c1;
            c1 ^= c2;
            
            l++;
            r--;
        }
    }
    
    return my_string;
}