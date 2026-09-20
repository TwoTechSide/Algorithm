#include <string>
#include <map>
#include <utility>
#include <cctype>
#include <algorithm>

#include <iostream>

using namespace std;

int solution(string str1, string str2) {
    map<pair<char, char>, int> um1;
    map<pair<char, char>, int> um2;
    int len1 = 0;
    int len2 = 0;
    
    for(int i=1; i<str1.size(); i++) {
        char c1 = tolower(str1[i-1]);
        char c2 = tolower(str1[i]);
        if ('a'<=c1 && c1<='z' && 'a'<=c2 && c2<='z') {
            um1[make_pair(c1, c2)]++;
            len1++;
        }
    }
    
    for(int i=1; i<str2.size(); i++) {
        char c1 = tolower(str2[i-1]);
        char c2 = tolower(str2[i]);
        if ('a'<=c1 && c1<='z' && 'a'<=c2 && c2<='z') {
            um2[make_pair(c1, c2)]++;
            len2++;
        }
    }
    
    int total = len1+len2;
    int ovl = 0;
    
    if (total == 0) return 65536;
    
    for(auto& p: um1) {
        const pair<char, char>& cp = p.first;
        const int i1 = p.second;
        int& i2 = um2[cp];
        
        ovl += min(i1, i2);
    }
    
    total -= ovl;
    
    return ovl * 65536 / total;
}