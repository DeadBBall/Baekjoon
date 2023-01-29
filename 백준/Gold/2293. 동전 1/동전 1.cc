#include <iostream>
using namespace std;
int n, k, money[100], dp[10001];

void solve()
{
	dp[0] = 1;
	for(int i = 0; i < n; i++)
	{
		for(int j = money[i]; j <= k; j++)
		{
			dp[j] += dp[j - money[i]];
		}
	}
	cout << dp[k];
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> k;
	for(int i = 0; i < n; i++)
		cin >> money[i];
	solve();
}