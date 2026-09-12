#include <string>
#include <vector>
#include <algorithm>

#include <iostream>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    int lux = wallpaper[0].size();
    int luy = wallpaper.size();
    int rdx = 0;
    int rdy = 0;
    
    for(int i=0; i<wallpaper.size(); i++) {
        for(int j=0; j<wallpaper[0].size(); j++) {
            if (wallpaper[i][j] == '#') {
                lux = min(lux, j);
                luy = min(luy, i);
                rdx = max(rdx, j+1);
                rdy = max(rdy, i+1);
            }
        }
    }
    
    return {luy, lux, rdy, rdx};
}