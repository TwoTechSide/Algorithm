#include <string>
#include <vector>

using namespace std;

int solution(int num, int k) {
    int pos = to_string(num).find(to_string(k));
    if (pos != -1) pos++;
         
    return pos;
}