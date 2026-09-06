#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;


vector<int> solution(vector<int> numlist, int n) {
    sort(numlist.begin(), numlist.end(), [n](int a, int b) {
        if (abs(a - n) != abs(b - n)) return abs(a - n) < abs(b - n);
        else return a > b;
    });
    return numlist;
}