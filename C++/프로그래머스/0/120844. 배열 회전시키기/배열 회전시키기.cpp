#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers, string direction) {
    vector<int> answer;
    
    if (direction == "right") {
        int temp = numbers.back();
        numbers.pop_back();
        numbers.insert(numbers.begin(), temp);
    }
    
    else if (direction == "left") {
        int temp = numbers.front();
        numbers.erase(numbers.begin());
        numbers.emplace_back(temp);
    }
    
    return numbers;
}