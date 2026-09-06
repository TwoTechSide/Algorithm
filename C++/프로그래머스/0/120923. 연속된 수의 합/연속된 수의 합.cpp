#include <string>
#include <vector>

using namespace std;

vector<int> solution(int num, int total) {
    vector<int> answer;
    int s = (total/num)-((num-1)/2);
    
    for (int i = s; i < s+num; i++) answer.push_back(i);
    return answer;
}