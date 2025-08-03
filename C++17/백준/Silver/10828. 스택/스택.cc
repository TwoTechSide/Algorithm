#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N; cin >> N;
    int stack[N];
    int pos = -1;

    for (int i=0; i<N; i++) {
        string str; cin >> str;
        if (str.compare("push") == 0) { cin >> stack[++pos]; }
        else if (str.compare("pop") == 0) { if (pos == -1) cout << "-1\n"; else cout << stack[pos--] << "\n"; }
        else if (str.compare("size") == 0) { cout << pos+1 << "\n"; }
        else if (str.compare("empty") == 0) { cout << ((pos == -1) ? 1 : 0) << "\n"; }
        else if (str.compare("top") == 0) { cout << ((pos != -1) ? stack[pos] : -1) << "\n"; }
    }
}