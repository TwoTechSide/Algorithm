#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <algorithm>

#include <iostream>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    vector<vector<int>> gift_arr(friends.size(), vector<int>(friends.size(), 0));
    vector<int> gift_idx(friends.size(), 0);
    unordered_map<string, int> unord_map;
    vector<int> res_gift(friends.size(), 0);
    
    for(int i=0; i<friends.size(); i++) unord_map[friends[i]] = i;
    
    for(const string& str: gifts) {
        istringstream iss(str);
        string from; string to;
        iss >> from >> to;
        int from_idx = unord_map[from];
        int to_idx = unord_map[to];
        
        gift_arr[from_idx][to_idx]++;
        gift_idx[from_idx]++;
        gift_idx[to_idx]--;
    }
    
    for(int i=1; i<friends.size(); i++) {
        for(int j=0; j<i; j++) {
            
            if (gift_arr[i][j] > gift_arr[j][i]) res_gift[i]++;
            else if (gift_arr[i][j] < gift_arr[j][i]) res_gift[j]++;
            
            if (gift_arr[i][j] == gift_arr[j][i]) {
                if (gift_idx[i] > gift_idx[j]) res_gift[i]++;
                else if (gift_idx[i] < gift_idx[j]) res_gift[j]++;
            }
        }
    }
    
    return *max_element(res_gift.begin(), res_gift.end());
}