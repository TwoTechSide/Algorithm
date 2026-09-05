#include <string>
#include <vector>

#include <iostream>

using namespace std;

int solution(int chicken) {
    int service = 0;
    int coupon = 0;
    
    while (chicken > 0) {
        
        cout << "chicken : " << chicken << endl;
        
        coupon += chicken;
        chicken = coupon / 10;
        service += coupon / 10;
        coupon %= 10;
    }
    
    return service;
}