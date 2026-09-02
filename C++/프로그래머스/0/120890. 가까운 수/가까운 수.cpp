#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> array, int n) {
    
    int minDiff = 100;
    int diffPos = 0;
    
    for (int i = 0; i < array.size(); i++) {
        int diff = abs(array[i] - n);
        
        if (diff < minDiff) {
            diffPos = i;
            minDiff = diff;
        } else if (diff == minDiff && array[i] < array[diffPos]) {
            diffPos = i;
        }
    }
    
    return array[diffPos];
}