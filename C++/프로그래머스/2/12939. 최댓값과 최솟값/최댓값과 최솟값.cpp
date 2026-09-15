#include <string>
#include <sstream>
#include <climits>
#include <algorithm>

using namespace std;

string solution(string s) {
    istringstream iss(s);

    int num;
    int m = INT_MAX;
    int M = INT_MIN;

    while (iss >> num) {
        m = min(m, num);
        M = max(M, num);
    }

    return to_string(m) + " " + to_string(M);
}