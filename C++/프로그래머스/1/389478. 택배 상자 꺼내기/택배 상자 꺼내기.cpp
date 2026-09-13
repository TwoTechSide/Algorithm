#include <string>
#include <vector>

using namespace std;

int solution(int n, int w, int num) {
    int x = 0;
    int y = 0;
    
    bool num_fill = false;
    int px = -1;
    
    int answer = 1;
    
    for(int i=0; i<n; i++) {
        if (i==num-1) {
            px = x;
            num_fill = true;
        } else if (px > -1 && px == x) answer++;
        
        if ((y%2==0 && x%w == w-1) || (y%2==1 && x%w == 0)) y++;
        else x += (y%2==0) ? 1 : -1;
    }
    
    return answer;
}