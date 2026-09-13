#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int ct = bandage[0];
    int rcv_ps = bandage[1];
    int rcv_ad = bandage[2];
    int cont = 0;
    int max_health = health;
    
    int rcv_time = 0;
    int atk_index = 0;
    int t = 0;
    
    for(int t=1;;t++) {
        
        if (t > attacks.back()[0])
            break;
        
        vector<int>& atk = attacks[atk_index];
        
        if (t == atk[0]) {
            health -= atk[1];
            atk_index++;
            rcv_time = 0;
            if (health <= 0) return -1;
            continue;
        }
        
        health += rcv_ps;
        if (++rcv_time % ct == 0) health += rcv_ad;
        if (health > max_health) health = max_health;
    }
    
    return health;
}