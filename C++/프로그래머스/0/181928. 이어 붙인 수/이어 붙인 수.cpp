#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> num_list) {
    int n1 = 0;
    int n2 = 0;
    
    for (int i = 0; i < num_list.size(); i++) {
        if ((num_list[i] & 1) == 0) {
            n2 = n2 * 10 + num_list[i];
        } else {
            n1 = n1 * 10 + num_list[i];
        }
    }
    
    return n1 + n2;
}