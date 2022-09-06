#include <stdio.h>

int dp[3][1000];

int main()
{
	int n, h1, h2, h3, ans;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
	{
		scanf("%d%d%d", &h1, &h2, &h3);
		if (!i)
		{
			dp[0][i] = h1;
			dp[1][i] = h2;
			dp[2][i] = h3;
		}
		else
		{
			dp[0][i] = dp[1][i - 1] > dp[2][i - 1] ? dp[2][i - 1] + h1 : dp[1][i - 1] + h1;
			dp[1][i] = dp[0][i - 1] > dp[2][i - 1] ? dp[2][i - 1] + h2 : dp[0][i - 1] + h2;
			dp[2][i] = dp[0][i - 1] > dp[1][i - 1] ? dp[1][i - 1] + h3 : dp[0][i - 1] + h3;
		}
	}
	ans = dp[0][n - 1];
	if (ans > dp[1][n - 1])
		ans = dp[1][n - 1];
	if (ans > dp[2][n - 1])
		ans = dp[2][n - 1];
	printf("%d", ans);
}