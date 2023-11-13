#include <iostream>
#include <algorithm>
using namespace std;

int n, ans;
int straws[1000001];

int main()
{
    cin >> n;
    ans = -1;
    
    for(int idx = 0; idx < n; idx++) {
        cin >> straws[idx];
    }
    sort(straws, straws + n);

    int a, b, c;
    for(int idx = n - 3; idx >= 0; idx--) {
        a = straws[idx];
        b = straws[idx + 1];
        c = straws[idx + 2];
        
        if(a + b > c) {
            ans = a + b + c;
            break;
        }
    }

    cout << ans;
    return 0;
}