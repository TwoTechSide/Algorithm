#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    return (num & 1) == 0 ? "Even" : "Odd";
}