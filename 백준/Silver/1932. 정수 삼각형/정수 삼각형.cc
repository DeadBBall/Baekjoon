#include <iostream>
#include <algorithm>
using namespace std;

int dp[501][501] = {0}, tri[501][501];
int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++)
		for(int j = 1; j <= i; j++)
			cin >> tri[j][i];
	dp[1][1] = tri[1][1];
	for(int i = 1; i <= n; i++)
		for(int j = 1; j <= i; j++)
		{
			if(i != 1)
			{
				dp[1][i] = dp[1][i - 1] + tri[1][i];
				dp[i][i] = dp[i - 1][i - 1] + tri[i][i];
			}
			if(j != 1 && j != i)
				dp[j][i] = dp[j - 1][i - 1] > dp[j][i - 1] ? dp[j - 1][i - 1] + tri[j][i] : dp[j][i - 1] + tri[j][i];
		}
	int ans = 0;
	for(int i = 1; i <= n; i++)
		ans = max(ans, dp[i][n]);
	cout << ans;
}