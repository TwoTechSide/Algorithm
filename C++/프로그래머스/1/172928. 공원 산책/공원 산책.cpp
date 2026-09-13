#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    int x;
    int y;
    
    for(int i=0; i<park.size(); i++) {
        bool done = false;
        for(int j=0; j<park[0].size(); j++) {
            if (park[i][j] == 'S') {
                x = j;
                y = i;
                done = true;
                break;
            }
        }
        if (done) break;
    }
    
    for(const string& r: routes) {
        int ox = x;
        int oy = y;
        
        istringstream iss(r);
        char c;
        int n;
        iss >> c >> n;
        
        int dx = ((c == 'E') - (c == 'W'));
        int dy = ((c == 'S') - (c == 'N'));
        vector<int> dv = {dy, dx};
        
        bool enable = true;
        
        for(int i=0; i<n; i++) {
            ox += dv[1];
            oy += dv[0];
            
            if (ox < 0 || ox >= park[0].size() || oy < 0 || oy >= park.size() || park[oy][ox] == 'X') {
                enable = false;
                break;
            }
        }
        
        if (enable) {
            x = ox;
            y = oy;
        }
    }
    return {y, x};
}