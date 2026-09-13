#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool check_available(const vector<vector<string>>& park, int size, int a, int b) {
    for(int y=a; y<a+size; y++) {
        for(int x=b; x<b+size; x++) {
            if (park[y][x] != "-1") return false;
        }
    }
    
    return true;
}

int solution(vector<int> mats, vector<vector<string>> park) {
    sort(mats.begin(), mats.end());
    int mats_index = 0;
    
    for(int y=0; y<park.size(); y++) {
        for(int x=0; x<park[0].size(); x++) {
            
            if (mats_index == mats.size()) return mats.back();
            
            while(mats_index < mats.size()) {
                
                if (y+mats[mats_index] > park.size() || x+mats[mats_index] > park[0].size()) break;
                if (!check_available(park, mats[mats_index], y, x)) break;
                
                mats_index++;
            }
        }
    }
    
    return mats_index > 0 ? mats[mats_index-1] : -1;
}