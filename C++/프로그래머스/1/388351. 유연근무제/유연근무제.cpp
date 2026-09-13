#include <vector>

using namespace std;

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int result = schedules.size();
    
    for(int i=0; i<schedules.size(); i++) {
        
        int dl = schedules[i] + 10;
        if (dl % 100 >= 60) dl += 40;
        
        const vector<int>& perlog = timelogs[i];
        for(int j=0; j<7; j++) {
            if ((j+startday) % 7 == 6 || (j+startday) % 7 == 0) continue;
            if (perlog[j] > dl) {
                result--;
                break;
            }
        }
    }
    
    return result;
}