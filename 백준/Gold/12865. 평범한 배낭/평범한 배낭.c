#include <stdio.h>

int dp[100001] = {0}, bag[2][101];
int main()
{
	int n, w;
	scanf("%d%d", &n, &w);
	for(int i = 1; i <= n; i++)
		scanf("%d%d", &bag[0][i], &bag[1][i]);
	for(int j = 1; j <= n; j++)
	{
		for(int i = w; i >= 1; i--)
			if(bag[0][j] <= i)
				dp[i] = dp[i] > dp[i - bag[0][j]] + bag[1][j] ? dp[i] : dp[i - bag[0][j]] + bag[1][j];
	}
	printf("%d", dp[w]);
}