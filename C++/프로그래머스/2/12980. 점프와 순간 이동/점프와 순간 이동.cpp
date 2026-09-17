#include <bitset>

using namespace std;

int solution(int n)
{
    return bitset<31>(n).count();
}