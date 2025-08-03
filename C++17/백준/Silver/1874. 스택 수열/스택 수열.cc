#include <iostream>
#include <stack>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(NULL);

    int n; cin >> n;

    int idx = 1;
    stack<int> st;

    string output = "";

    for(int i=0; i<n; i++) {
        int num; cin >> num;

        if (num >= idx) {
            for(int i=idx; i<num; i++) {
                output += "+\n";
                st.push(i);
            }
            idx = num+1;
            output += "+\n-\n";
        } else {
            int p = st.top();
            st.pop();

            if (p != num) {
                cout << flush << "NO";
                output = "";
                break;
            }
            output += "-\n";
        }
    }

    cout << output;

    return 0;
}