#include <iostream>
using namespace std;

int t, n, money[20], m;

void input()
{
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		cin >> money[i];
	}
	cin >> m;
}

void checkMoney()
{
	int dp[10001] = {1};
	for(int i = 0; i < n; i++)
	{
		for(int j = money[i]; j <= m; j++)
		{
			dp[j] += dp[j - money[i]];
		}
	}
	cout << dp[m] << "\n";
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		input();
		checkMoney();
	}
}
