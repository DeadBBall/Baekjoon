#include <stdio.h>

int arr[10000], dp[10000];

int MAX(int a, int b)
{
  return a > b ? a : b;
}

int main()
{
	int n;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	dp[0] = arr[0];
	if(n >= 2)
		dp[1] = dp[0] + arr[1];
	for(int i = 2; i < n; i++)
		dp[i] = MAX(dp[i - 2] + arr[i], MAX(dp[i - 3] + arr[i-1]+ arr[i], dp[i - 1]));
	printf("%d", dp[n - 1]);
}