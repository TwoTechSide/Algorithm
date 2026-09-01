#include <string>
#include <vector>

#include <iostream>

using namespace std;

int solution(vector<int> num_list) {
    int even = 0;
    int odd = 0;
    
    for (int i = 0; i < num_list.size(); i++) {
        if ((i & 1) == 0) {
            even += num_list[i];
        } else {
            odd += num_list[i];
        }
    }
    
    return (even > odd) ? even : odd;
}