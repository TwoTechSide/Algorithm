#include <iostream>
#include <climits>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int *cnt; cnt = (int*)malloc(sizeof(int)*1000001);
    cnt[1] = 0;

    for(int i=2; i<1000001; i++) {
        int minCnt = INT_MAX;

        if (i%3 == 0) minCnt = (cnt[i/3] < minCnt) ? cnt[i/3] : minCnt;
        if (i%2 == 0) minCnt = (cnt[i/2] < minCnt) ? cnt[i/2] : minCnt;
        minCnt = (cnt[i-1] < minCnt) ? cnt[i-1] : minCnt;

        cnt[i] = minCnt+1;
    }

    int X; cin >> X;
    cout << cnt[X];
}