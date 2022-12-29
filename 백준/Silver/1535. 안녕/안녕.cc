#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, hp[21], joy[21], dp[21][100] = {0};
	cin >> n;
	for(int i = 1; i <= n; i++)
		cin >> hp[i];
	for(int i = 1; i <= n; i++)
		cin >> joy[i];
	for(int i = 1; i <= n; i++)
	{
		for(int j = 1; j < 100; j++)
		{
			if(hp[i] <= j)
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - hp[i]] + joy[i]);
			else
				dp[i][j] = dp[i - 1][j];
		}
	}
	cout << dp[n][99];
}