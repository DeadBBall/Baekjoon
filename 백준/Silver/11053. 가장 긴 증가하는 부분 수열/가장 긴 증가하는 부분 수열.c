#include <stdio.h>

int dp[1000] = {1}, arr[1000];

int main()
{
	int n, max = 1;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	for(int i = 1; i < n; i++)
	{
		dp[i] = 1;
		for(int j = 0; j < i; j++)
		{
			if (arr[j] < arr[i])
				dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
		}
		if (dp[i] > max)
			max = dp[i];
	}
	printf("%d", max);
}