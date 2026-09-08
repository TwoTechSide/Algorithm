using namespace std;

long long solution(int price, int money, int count)
{
    long long n = static_cast<long long>(count);
    long long answer = n * (n+1) / 2 * price - money;
    return answer > 0 ? answer : 0;
}