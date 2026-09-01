#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int n) {
    string answer = my_string.substr(my_string.length() - n, my_string.length());
    return answer;
}