#include <stdio.h>

int dp[101][10] = {0};

int main()
{
	int n;
	int sum = 0;
	scanf("%d", &n);
	for(int i = 1; i <= 9; i++)
		dp[1][i] = 1;
	for(int i = 2; i <= n; i++)
	{
		for(int j = 0; j <= 9; j++)
		{
			if (!j)
				dp[i][j] = dp[i - 1][1] % 1000000000;
			else if (j == 9)
				dp[i][j] = dp[i - 1][8] % 1000000000;
			else
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
		}
	}
	for(int i = 0; i <= 9; i++)
		sum = (sum + dp[n][i]) % 1000000000;
	printf("%d", sum);
}