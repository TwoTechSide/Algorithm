#include <string>
#include <vector>

using namespace std;

int solution(string A, string B) {
    
    if (A == B) return 0;
    
    int answer = 0;
    int str_size = A.size();
    
    for (int i = 0; i < str_size-1; i++) {
        A = A[str_size-1] + A;
        A.resize(str_size);
        
        if (A == B) return i+1;
    }
    
    return -1;
}