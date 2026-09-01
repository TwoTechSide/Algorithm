#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int n1 = 1;
    int n2 = 0;
    
    for(int n: num_list) {
        n1 *= n;
        n2 += n;
    }
    
    return (n1 < n2*n2);
}