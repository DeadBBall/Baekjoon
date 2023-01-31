#include <iostream>
#include <algorithm>
using namespace std;
typedef pair <int, int> pii;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    pii arr[101];
    int dp[101];
    int ans = 0;
    for(int i = 0; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[i] = make_pair(a, b);
    }
    sort(arr, arr + n);
    for(int i = 0; i < n; i++)
    {
        dp[i] = 1;
        for(int j = 0; j < i; j++)
        {
            if(arr[j].second < arr[i].second)
            {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        ans = max(dp[i], ans);
    }
    cout << n - ans;
}