#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    
    int size = 1;
    while (size < arr.size()) {
        size *= 2;
    }
    
    while (arr.size() < size) {
        arr.emplace_back(0);
    }
    
    return arr;
}