#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    phone_number.replace(0, phone_number.size()-4, string(phone_number.size()-4, '*'));
    return phone_number;
}